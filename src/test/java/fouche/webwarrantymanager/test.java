package fouche.webwarrantymanager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fouche.webwarrantymanager.app.conf.connectionConfig;
import com.fouche.webwarrantymanager.domain.unit;
import com.fouche.webwarrantymanager.domain.user;
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
    private String unitID;
    private String productID;
    
    
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
        productsRepo = ctx.getBean(productsRepository.class);
        retailerRepo = ctx.getBean(retailerRepository.class);        
        userRepo = ctx.getBean(userRepository.class);       
        warrantyRepo = ctx.getBean(warrantyRepository.class);
            
        Date d = new Date(1991,07,8);
        unit u = new unit.Builder()
                .setPurchaseDate(d)
                .setSn("123A321")
                .build();
        
        user us = new user.Builder() 
                .setEmail("a@c.com")
                .setPwd("")
                .setName("")
                .setSurname("")
                .setContact("")
                .setAddress("")
                .build();
        
        unitRepo.save(u);
       /* songID = s.getId();
        songs.add(s);
        
        CD c = new CD.Builder()
                .setAlbum(a.getName())
                .setArtist("Dance Gavin Dance")
                .setSongID(songID)
                .build();
        
        Vinyl v = new Vinyl.Builder()
                .setAlbum(a.getName())
                .setArtist("Dance Gavin Dance")
                //.setSongList(songs)
                .build();
        
        Album b = new Album.Builder()
                .Album(a)
                .setCd(c)
                .setVinyl(v)
                .build();
                
        albumRepo.save(b);
        id = b.getId();
        Assert.assertNotNull(b);
        */
    }/*
    @Test(dependsOnMethods = "createUnit")
    public void readAlbum(){
        albumRepo = ctx.getBean(AlbumRepository.class);
        Album album = albumRepo.findOne(id);
        Assert.assertEquals(album.getName(), "Downtown Battle Mountain II");
    }
    
    @Test(dependsOnMethods = "createAlbum")
    private void updateAlbum(){
        albumRepo = ctx.getBean(AlbumRepository.class);
    }
    
    @Test(dependsOnMethods = "updateAlbum")
    private void deleteAlbum(){
        albumRepo = ctx.getBean(AlbumRepository.class);
        albumRepo.delete(id);
        songRepo.delete(songID);
        Song song = songRepo.findOne(songID);
        Album album = albumRepo.findOne(id);
        Assert.assertNull(song);
        Assert.assertNull(album);
        
    }*/
    
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
