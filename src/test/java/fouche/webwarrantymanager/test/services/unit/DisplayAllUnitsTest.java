/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fouche.webwarrantymanager.test.services.unit;

import com.fouche.webwarrantymanager.domain.Unit;
import com.fouche.webwarrantymanager.repository.UnitRepository;
import com.fouche.webwarrantymanager.services.UnitsService;
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
public class DisplayAllUnitsTest {
    private static ApplicationContext ctx;
    //private UnitsService unitsService;
    private UnitRepository unitRepo;
    private Long unitID;
    public DisplayAllUnitsTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void createUnit(){
        unitRepo = ctx.getBean(UnitRepository.class);        
        //unitsService = ctx.getBean(UnitsService.class);
        
        Unit un1 = new Unit.Builder()
                .setPurchaseDate("08-07-1991")
                .setSn("123A323")
                .build();
        
        unitRepo.save(un1); 
        
        unitID = un1.getUnitID();
        Assert.assertNotNull(un1);
       
    }
    @Test (dependsOnMethods = "createUnit")
    public void readUnitTest() {
        unitRepo = ctx.getBean(UnitRepository.class);
        Unit obj = unitRepo.findOne(unitID);

        Assert.assertEquals(obj.getSn(), "123A323");
    }
    @Test(dependsOnMethods = "readUnitTest")
     private void updateUnit(){
         unitRepo = ctx.getBean(UnitRepository.class);
         Unit un = unitRepo.findOne(unitID);
         unitRepo = ctx.getBean(UnitRepository.class);
         Unit unpdatedUnit = new Unit.Builder(un.getSn())
                 .setPurchaseDate("12-2-2014")
                .build();
         unitRepo.delete(unitID);
         unitRepo.save(unpdatedUnit);
         unitID = unpdatedUnit.getUnitID();
         Unit unUp = unitRepo.findOne(unitID);
         Assert.assertEquals(unUp.getPurchaseDate(), "12-2-2014");
         
     }
     @Test(dependsOnMethods = "updateUnit")
     private void deleteUnit(){
        unitRepo = ctx.getBean(UnitRepository.class);
        unitRepo.delete(unitID);
       
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
        //unitRepo.deleteAll();
    }
}
