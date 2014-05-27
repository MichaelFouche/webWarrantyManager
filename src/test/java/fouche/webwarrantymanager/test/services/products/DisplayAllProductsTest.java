/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fouche.webwarrantymanager.test.services.products;

import com.fouche.webwarrantymanager.domain.Products;
import com.fouche.webwarrantymanager.domain.Unit;
import com.fouche.webwarrantymanager.repository.ProductsRepository;
import com.fouche.webwarrantymanager.services.ProductService;
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
public class DisplayAllProductsTest {
    private static ApplicationContext ctx;
    private ProductService productService;
    private ProductsRepository productsRepo;
    
    public DisplayAllProductsTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void getAllProducts() {
        productsRepo = ctx.getBean(ProductsRepository.class);
        productService = ctx.getBean(ProductService.class);
        
        Products prod1 = new Products.Builder()
                    .setMake("Samsung")
                    .setModel("S4")
                    .build();
        
        
        Products prod2 = new Products.Builder()
                    .setMake("Samsung")
                    .setModel("S4")
                    .build();
        
        
        Products prod3 = new Products.Builder()
                    .setMake("Samsung")
                    .setModel("S4")
                    .build();
        
        productsRepo.save(prod1); 
        productsRepo.save(prod2); 
        productsRepo.save(prod3); 
         

        List<Products> productList = new ArrayList<>();
        productList = productService.getAllProducts();

        Assert.assertEquals(productList.size(), 3);

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
