/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fouche.webwarrantymanager.test.services.products;

import com.fouche.webwarrantymanager.domain.Products;
import com.fouche.webwarrantymanager.domain.Unit;
import com.fouche.webwarrantymanager.repository.ProductsRepository;
import com.fouche.webwarrantymanager.repository.UnitRepository;
import com.fouche.webwarrantymanager.services.products.DisplayProductsMakePurchasedOnService;
import fouche.webwarrantymanager.test.ConnectionConfigTest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
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
public class DisplayProductsMakePurchasedOnTest {
    private static ApplicationContext ctx;
    private DisplayProductsMakePurchasedOnService displayProductsMakePurchasedOnService;
    private UnitRepository unitRepo;
    private ProductsRepository productsRepo;
    
    public DisplayProductsMakePurchasedOnTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void getProductsMakePurchasedOnService() {
        productsRepo = ctx.getBean(ProductsRepository.class);
        displayProductsMakePurchasedOnService = ctx.getBean(DisplayProductsMakePurchasedOnService.class);
        unitRepo = ctx.getBean(UnitRepository.class);
        
        Products prod1 = new Products.Builder()
                    .setMake("Samsung")
                    .setModel("S4")
                    .build();
        Unit un1 = new Unit.Builder()
                .setPurchaseDate("08-07-1991")
                .setSn("123A323")
                .setProductID(prod1.getProductID())
                .build();
        Products prod2 = new Products.Builder()
                    .setMake("Samsung")
                    .setModel("S4-Mini")
                    .build();
        Unit un2 = new Unit.Builder()
                .setPurchaseDate("08-07-1991")
                .setSn("123A323")
                .setProductID(prod2.getProductID())
                .build();
        
        Products prod3 = new Products.Builder()
                    .setMake("LG")
                    .setModel("G2")
                    .build();
        Unit un3 = new Unit.Builder()
                .setPurchaseDate("08-07-1991")
                .setSn("123A323")
                .setProductID(prod3.getProductID())
                .build();
        unitRepo.save(un1); 
        productsRepo.save(prod1); 
        unitRepo.save(un2);
        productsRepo.save(prod2);
        unitRepo.save(un3);
        productsRepo.save(prod3);

        List<Products> productList = new ArrayList<>();
//        productList = displayProductsMakePurchasedOnService.getProductsMakePurchasedOn("Samsung", "08-07-1991");//make, purchasedOn

       // Assert.assertEquals(productList.size(), 2);

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
        productsRepo = ctx.getBean(ProductsRepository.class);
        productsRepo.deleteAll();
        unitRepo = ctx.getBean(UnitRepository.class);
        unitRepo.deleteAll();
    }
}
