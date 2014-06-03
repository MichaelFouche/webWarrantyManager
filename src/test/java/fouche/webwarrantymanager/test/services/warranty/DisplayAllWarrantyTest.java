/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fouche.webwarrantymanager.test.services.warranty;

import com.fouche.webwarrantymanager.domain.Warranty;
import com.fouche.webwarrantymanager.repository.WarrantyRepository;
import com.fouche.webwarrantymanager.services.WarrantyService;
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
public class DisplayAllWarrantyTest {
    private static ApplicationContext ctx;
    private WarrantyService warrantyService;
    private WarrantyRepository warrantyRepo;
    
    public DisplayAllWarrantyTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void getAllWarranty() {
        warrantyRepo = ctx.getBean(WarrantyRepository.class);
        warrantyRepo.deleteAll();
        warrantyService = ctx.getBean(WarrantyService.class);
        Warranty warr1 = new Warranty.Builder()
                .setReplaceDuration(5)
                .setRepairDuration(5)
                .build();
        Warranty warr2 = new Warranty.Builder()
                .setReplaceDuration(5)
                .setRepairDuration(5)
                .build();
        Warranty warr3 = new Warranty.Builder()
                .setReplaceDuration(5)
                .setRepairDuration(5)
                .build();
        warrantyRepo.save(warr1);
        warrantyRepo.save(warr2);
        warrantyRepo.save(warr3);
        List<Warranty> warrantyList = new ArrayList<>();
        warrantyList = warrantyService.getAllWarranty();
        Assert.assertEquals(warrantyList.size(), 3);
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
        warrantyRepo = ctx.getBean(WarrantyRepository.class);
        warrantyRepo.deleteAll();
    }
}
