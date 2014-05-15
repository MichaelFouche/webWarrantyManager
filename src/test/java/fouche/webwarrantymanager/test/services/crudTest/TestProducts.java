/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fouche.webwarrantymanager.test.services.crudTest;

import fouche.webwarrantymanager.test.ConnectionConfigTest;
import com.fouche.webwarrantymanager.domain.Products;
import com.fouche.webwarrantymanager.domain.Unit;
import com.fouche.webwarrantymanager.repository.ProductsRepository;
import com.fouche.webwarrantymanager.repository.UnitRepository;
import static fouche.webwarrantymanager.test.services.crudTest.TestDatabase.ctx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Michael
 */
public class TestProducts {
    private UnitRepository unitRepo;
    private ProductsRepository productsRepo;
    private Long productID;
    private Long unitID;
    
    public TestProducts() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test  (enabled = false)
    public void createUnit(){
    unitRepo = ctx.getBean(UnitRepository.class);
    productsRepo = ctx.getBean(ProductsRepository.class);
    
    
    Products prod = new Products.Builder()
                .setMake("Samsung")
                .setModel("S4")
                .build();
    Unit un = new Unit.Builder()
                .setPurchaseDate("08-07-1991")
                .setSn("123A321")
                .setProductID(prod.getProductID())
                .build();
    unitRepo.save(un); 
    productsRepo.save(prod); 
    unitID = un.getUnitID();
    productID = prod.getProductID();
    }
    
    @Test(enabled = false, dependsOnMethods = "createUnit")
    public void readUnit(){
        productsRepo = ctx.getBean(ProductsRepository.class);
        Products pr = productsRepo.findOne(productID);
        Assert.assertNotNull(pr.getModel());
        Assert.assertEquals(pr.getModel(), "S4");
    }
    
    @Test(enabled = false,dependsOnMethods = "readUnit")
    private void updateUnit(){
        productsRepo = ctx.getBean(ProductsRepository.class);
        Products pr = productsRepo.findOne(productID);
        productID = pr.getProductID();
        Products updateProducts = new Products.Builder(pr.getMake())  
                .setModel("S4-mini")
                .build();        
        productsRepo.save(updateProducts);     
        productsRepo.delete(unitID);
        productID = updateProducts.getProductID();
        Products prUp = productsRepo.findOne(productID);
        Assert.assertEquals(prUp.getModel(), "S4-mini");
    }
    
    @Test(enabled = false, dependsOnMethods = "updateUnit")
    private void deleteUnit(){
        productsRepo = ctx.getBean(ProductsRepository.class);        
        productsRepo.delete(productID);
       // productsRepo.delete(retailerID);
        Unit un = unitRepo.findOne(productID);
        Assert.assertNull(un);
        
    }
    
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod 
    public void tearDownMethod() throws Exception {
        unitRepo = ctx.getBean(UnitRepository.class);
        productsRepo = ctx.getBean(ProductsRepository.class);
       // unitRepo.deleteAll();
       // productsRepo.deleteAll();
    }
}
