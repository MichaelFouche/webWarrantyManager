/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.presentation.rest;

import com.fouche.webwarrantymanager.domain.Products;
import com.fouche.webwarrantymanager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author foosh
 */
//@Controller
public class ProductRestController {
    /*@Autowired
    private ProductService productService;
    
    @RequestMapping(value = "create",method = RequestMethod.POST) // This the uri e.g http://localhost:8084/askweb/api/club/create
    @ResponseBody //Converts output or response to JSON String
    public String create(@RequestBody Products products) { // @RequestBody for converting incoming JSON call to Object
        productService.persist(products);
        
        System.out.println(" Create Called ");
        return "Product Created";
    }*/
}
