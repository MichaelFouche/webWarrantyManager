/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fouche.webwarrantymanager.test.services.products;

import com.fouche.webwarrantymanager.domain.Products;
import com.fouche.webwarrantymanager.repository.ProductsRepository;
import com.fouche.webwarrantymanager.services.products.DisplayProductsWithIdService;
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
public class DisplayProductsWithIdTest {
    private static ApplicationContext ctx;
    private DisplayProductsWithIdService displayProductsWithIdService;
    private ProductsRepository productsRepo;
    private Long id1, id2, id3;
    public DisplayProductsWithIdTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void getAllProducts() {
        productsRepo = ctx.getBean(ProductsRepository.class);
        displayProductsWithIdService = ctx.getBean(DisplayProductsWithIdService.class);
        
        Products prod1 = new Products.Builder()
                    .setMake("Samsung")
                    .setModel("S4")
                    .build();
        id1 = prod1.getProductID();
        Products prod2 = new Products.Builder()
                    .setMake("Samsung")
                    .setModel("S4-Mini")
                    .build();
        id2 = prod2.getProductID();
        Products prod3 = new Products.Builder()
                    .setMake("LG")
                    .setModel("G2")
                    .build();
        id3 = prod3.getProductID();
        productsRepo.save(prod1); 
        productsRepo.save(prod2); 
        productsRepo.save(prod3); 

        List<Products> productList = new ArrayList<>();
        productList = displayProductsWithIdService.getProductsWithId(id1);

        Assert.assertEquals(displayProductsWithIdService.getProductsWithId(id1),productList );

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
    }
}
