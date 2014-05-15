/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fouche.webwarrantymanager.test.services.unit;

import com.fouche.webwarrantymanager.domain.Unit;
import com.fouche.webwarrantymanager.repository.UnitRepository;
import com.fouche.webwarrantymanager.services.unit.DisplayAllUnitsService;
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
    private DisplayAllUnitsService displayAllUnitsService;
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
    public void getAllUnits() {
        unitRepo = ctx.getBean(UnitRepository.class);
        displayAllUnitsService = ctx.getBean(DisplayAllUnitsService.class);
        
        Unit un1 = new Unit.Builder()
                .setPurchaseDate("08-07-1991")
                .setSn("123A323")
                .build();
        Unit un2 = new Unit.Builder()
                .setPurchaseDate("07-07-1991")
                .setSn("123A322")
                .build();
        Unit un3 = new Unit.Builder()
                .setPurchaseDate("06-07-1991")
                .setSn("123A321")
                .build();
        unitRepo.save(un1); 
        unitRepo.save(un2); 
        unitRepo.save(un3); 
        unitID = un1.getUnitID();
        List<Unit> unitList = new ArrayList<>();
        unitList = displayAllUnitsService.getAllUnits();

        Assert.assertEquals(unitList.size(), 3);

    }
    @Test(dependsOnMethods = "getAllUnits")
    public void readUnitTestDB(){
        unitRepo = ctx.getBean(UnitRepository.class);
        Unit un = unitRepo.findOne(unitID);
     //   System.out.println("Current unitID"+unitID+"\n"+un.getSn()+"\n");
        Assert.assertEquals(un.getSn(), "123A323");
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
