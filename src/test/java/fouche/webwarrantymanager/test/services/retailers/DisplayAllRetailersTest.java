/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fouche.webwarrantymanager.test.services.retailers;

import com.fouche.webwarrantymanager.domain.Retailer;
import com.fouche.webwarrantymanager.repository.RetailerRepository;
import com.fouche.webwarrantymanager.services.RetailersService;
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
public class DisplayAllRetailersTest {
    
    private static ApplicationContext ctx;
    private RetailersService retailersService;
    private RetailerRepository retailerRepo;
    
    public DisplayAllRetailersTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void getAllRetailers() {
        retailerRepo = ctx.getBean(RetailerRepository.class);
        retailerRepo.deleteAll();
        retailersService = ctx.getBean(RetailersService.class);
        
        Retailer retail1 = new Retailer.Builder()
                .setName("Checkers")
                .setAddress("Cape Town")
                .setContact("021")
                .build();
        Retailer retail2 = new Retailer.Builder()
                .setName("Checkers")
                .setAddress("Brackenfell")
                .setContact("022")
                .build();
        Retailer retail3 = new Retailer.Builder()
                .setName("Woolworths")
                .setAddress("Helderberg")
                .setContact("020")
                .build();
        retailerRepo.save(retail1); 
        retailerRepo.save(retail2); 
        retailerRepo.save(retail3); 

        List<Retailer> retailList = new ArrayList<>();
        retailList = retailersService.getAllRetailers();

        Assert.assertEquals(retailList.size(), 3);

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
        retailerRepo = ctx.getBean(RetailerRepository.class);
        retailerRepo.deleteAll();
    }
}
