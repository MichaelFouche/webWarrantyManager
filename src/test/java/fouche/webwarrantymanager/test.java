package fouche.webwarrantymanager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fouche.webwarrantymanager.app.conf.connectionConfig;
import com.fouche.webwarrantymanager.domain.products;
import com.fouche.webwarrantymanager.domain.retailer;
import com.fouche.webwarrantymanager.domain.unit;
import com.fouche.webwarrantymanager.domain.users;
import com.fouche.webwarrantymanager.domain.warranty;
import com.fouche.webwarrantymanager.repository.productsRepository;
import com.fouche.webwarrantymanager.repository.retailerRepository;
import com.fouche.webwarrantymanager.repository.unitRepository;
import com.fouche.webwarrantymanager.repository.userRepository;
import com.fouche.webwarrantymanager.repository.warrantyRepository;
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
public class test {
    public static ApplicationContext ctx;
    private unitRepository unitRepo;
    private productsRepository productsRepo;
    private retailerRepository retailerRepo;
    private userRepository userRepo;
    private warrantyRepository warrantyRepo;
    
    private Long unitID;
    private Long retailerID;
    private Long warrantyID;
    private Long productID;
    private String email;

    
    public test() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void createUnit(){
        
        unitRepo = ctx.getBean(unitRepository.class);
        /**productsRepo = ctx.getBean(productsRepository.class);
        retailerRepo = ctx.getBean(retailerRepository.class);        
        userRepo = ctx.getBean(userRepository.class);       
        warrantyRepo = ctx.getBean(warrantyRepository.class);*/
        
        
            
        
        unit un = new unit.Builder()
                .setPurchaseDate("08-07-1991")
                .setSn("123A321")
                .build();
        
        /*user us = new user.Builder() 
                .setEmail(un.getEmail())
                .setPwd("")
                .setName("")
                .setSurname("")
                .setContact("")
                .setAddress("")
                .build();
        
        products prod = new products.Builder()
                .setProductID(un.getProductID())
                .setMake("")
                .setModel("")
                .build();
        
        retailer retail = new retailer.Builder()
                .setRetailerID(un.getRetailerID())
                .setName("")
                .setAddress("")
                .setContact("")
                .build();
        warranty warr = new warranty.Builder()
                .setWarrantyID(un.getWarrantyID())
                .setReplaceDuration(5)
                .setRepairDuration(5)
                .build();*/
                
        unitRepo.save(un);        
        
        /*productsRepo.save(prod); 
        retailerRepo.save(retail);
        userRepo.save(us);
        warrantyRepo.save(warr);
        
       
        unitID = un.getUnitID();
        retailerID = un.getRetailerID();
        warrantyID = un.getWarrantyID();
        productID = un.getProductID();
        email = un.getEmail();*/
        
        unitID = un.getUnitID();
        Assert.assertNotNull(unitID);
    }
    @Test(dependsOnMethods = "createUnit")
    public void readUnit(){
        //unitRepo = ctx.getBean(unitRepository.class);
        unit un = unitRepo.findOne(unitID);
        //Date d = new Date(1991,07,8);
        //Assert.assertEquals(un.getPurchaseDate(), d);
    }
    
    @Test(dependsOnMethods = "readUnit")
    private void updateUnit(){
        unitRepo = ctx.getBean(unitRepository.class);
    }
    
    @Test(dependsOnMethods = "updateUnit")
    private void deleteUnit(){
        unitRepo = ctx.getBean(unitRepository.class);
        unitRepo.delete(unitID);
        productsRepo.delete(retailerID);
        unit un = unitRepo.findOne(unitID);
        Assert.assertEquals(un.getSn(),null);
        
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(connectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
