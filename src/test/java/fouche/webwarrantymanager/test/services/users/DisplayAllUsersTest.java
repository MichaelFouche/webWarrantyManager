/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fouche.webwarrantymanager.test.services.users;

import com.fouche.webwarrantymanager.domain.Users;
import com.fouche.webwarrantymanager.repository.UserRepository;
import com.fouche.webwarrantymanager.services.users.DisplayAllUsersService;
import fouche.webwarrantymanager.test.ConnectionConfigTest;
import static fouche.webwarrantymanager.test.services.crudTest.TestDatabase.ctx;
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
public class DisplayAllUsersTest {
    private static ApplicationContext ctx;
    private DisplayAllUsersService displayAllUsersService;
    private UserRepository userRepo;
    public DisplayAllUsersTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void getAllUsers() {
        userRepo = ctx.getBean(UserRepository.class); 
        displayAllUsersService = ctx.getBean(DisplayAllUsersService.class);
        Users us1 = new Users.Builder() 
                .setEmail("user@email.com")
                .setPwd("")
                .setName("")
                .setSurname("")
                .setContact("")
                .setAddress("")
                .build();
        Users us2 = new Users.Builder() 
                .setEmail("user@email.com")
                .setPwd("")
                .setName("")
                .setSurname("")
                .setContact("")
                .setAddress("")
                .build();
        Users us3 = new Users.Builder() 
                .setEmail("user@email.com")
                .setPwd("")
                .setName("")
                .setSurname("")
                .setContact("")
                .setAddress("")
                .build();
        userRepo.save(us1);
        userRepo.save(us2);
        userRepo.save(us3);
        
        List<Users> unitList = new ArrayList<>();
        unitList = displayAllUsersService.getAllUsers();
        Assert.assertEquals(unitList.size(), 3);
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
        userRepo = ctx.getBean(UserRepository.class); 
        userRepo.deleteAll();
    }
}
