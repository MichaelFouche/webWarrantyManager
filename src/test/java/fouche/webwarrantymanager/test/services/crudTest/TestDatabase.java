package fouche.webwarrantymanager.test.services.crudTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.fouche.webwarrantymanager.domain.Products;
import com.fouche.webwarrantymanager.domain.Retailer;
import com.fouche.webwarrantymanager.domain.Unit;
import com.fouche.webwarrantymanager.domain.Users;
import com.fouche.webwarrantymanager.domain.Warranty;
import com.fouche.webwarrantymanager.repository.ProductsRepository;
import com.fouche.webwarrantymanager.repository.RetailerRepository;
import com.fouche.webwarrantymanager.repository.UnitRepository;
import com.fouche.webwarrantymanager.repository.UserRepository;
import com.fouche.webwarrantymanager.repository.WarrantyRepository;
import fouche.webwarrantymanager.test.ConnectionConfigTest;
import java.util.ArrayList;
import java.util.Date;
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
 * @author foosh
 */
public class TestDatabase {
    public static ApplicationContext ctx;
    private UnitRepository unitRepo;
    private ProductsRepository productsRepo;
    private RetailerRepository retailerRepo;
    private UserRepository userRepo;
    private WarrantyRepository warrantyRepo;
    
    private Long unitID;
    private Long retailerID;
    private Long warrantyID;
    private Long productID;
    private Long userID;

    
    public TestDatabase() {
    }
 
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test (enabled = true)
    public void createUnitTestDB(){
        
        unitRepo = ctx.getBean(UnitRepository.class);
        productsRepo = ctx.getBean(ProductsRepository.class);
        retailerRepo = ctx.getBean(RetailerRepository.class);        
        userRepo = ctx.getBean(UserRepository.class);       
        warrantyRepo = ctx.getBean(WarrantyRepository.class);
        
        Unit un = new Unit.Builder()
                .setPurchaseDate("08-07-1991")
                .setSn("123A321")
                .build();
        
        Users us = new Users.Builder() 
                .setUserID(un.getUserID())
                .setEmail("user@email.com")
                .setPwd("")
                .setName("")
                .setSurname("")
                .setContact("")
                .setAddress("")
                .build();
        
        Products prod = new Products.Builder()
                .setProductID(un.getProductID())
                .setMake("")
                .setModel("")
                .build();
        
        Retailer retail = new Retailer.Builder()
                .setRetailerID(un.getRetailerID())
                .setName("")
                .setAddress("")
                .setContact("")
                .build();
        Warranty warr = new Warranty.Builder()
                .setWarrantyID(un.getWarrantyID())
                .setReplaceDuration(5)
                .setRepairDuration(5)
                .build();
                
        unitRepo.save(un);        
        
        productsRepo.save(prod); 
        retailerRepo.save(retail);
        userRepo.save(us);
        warrantyRepo.save(warr);
        
       
        unitID = un.getUnitID();
        retailerID = retail.getRetailerID();
        warrantyID = warr.getWarrantyID();
        productID = prod.getProductID();
        userID = us.getUserID();
        
        Assert.assertNotNull(unitID);
        Assert.assertNotNull(retailerID);
        Assert.assertNotNull(warrantyID);
        Assert.assertNotNull(productID);
        Assert.assertNotNull(userID);
    }
    @Test (dependsOnMethods = "createUnitTestDB") 
    public void readUnitTestDB(){
        unitRepo = ctx.getBean(UnitRepository.class);
        Unit un = unitRepo.findOne(unitID);
        System.out.println("Current unitID"+unitID+"\n"+un.getSn()+"\n");
        Assert.assertEquals(un.getSn(), "123A321");
    }
    
    @Test(dependsOnMethods = "readUnitTestDB")
    private void updateUnitTestDB(){
        unitRepo = ctx.getBean(UnitRepository.class);
        Unit un = unitRepo.findOne(unitID);
        unitID = un.getUnitID();
        Unit updateUnit = new Unit.Builder(un.getSn())  
                .setPurchaseDate("12-2-2014")
                .build();        
        unitRepo.save(updateUnit);     
        unitRepo.delete(unitID);
        unitID = updateUnit.getUnitID();
        Unit unUp = unitRepo.findOne(unitID);
        Assert.assertEquals(unUp.getPurchaseDate(), "12-2-2014");
    }
    
    @Test(dependsOnMethods = "updateUnitTestDB")
    private void deleteUnitTestDB(){
        unitRepo = ctx.getBean(UnitRepository.class);
        unitRepo.delete(unitID);
       // productsRepo.delete(retailerID);
        Unit un = unitRepo.findOne(unitID);
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
        retailerRepo = ctx.getBean(RetailerRepository.class);        
        userRepo = ctx.getBean(UserRepository.class);       
        warrantyRepo = ctx.getBean(WarrantyRepository.class);
        
    /*    unitRepo.deleteAll();
        productsRepo.deleteAll();
        retailerRepo.deleteAll();
        userRepo.deleteAll();
        warrantyRepo.deleteAll();*/
    }
}
