/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.presentation;

import com.fouche.webwarrantymanager.domain.Products;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Bob
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getIndex(){
        return "index";
    }
    
    @RequestMapping(value = "/rest",method = RequestMethod.POST)
    @ResponseBody
    public List<Products> getProductRest(){
        List<Products> productList = new ArrayList<>();
        Products prod1 = new Products.Builder()
                    .setMake("Samsung")
                    .setModel("S4")
                    .build();
        
        
        Products prod2 = new Products.Builder()
                    .setMake("Samsung")
                    .setModel("S4")
                    .build();
        productList.add(prod1);
        productList.add(prod2);
        
        
        return productList;
    }
}
