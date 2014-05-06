/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.Impl.products;

import com.fouche.webwarrantymanager.domain.Products;
import com.fouche.webwarrantymanager.repository.ProductsRepository;
import com.fouche.webwarrantymanager.services.products.DisplayAllProductsService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Michael
 */
@Service
public class DisplayAllProductsServiceImpl implements DisplayAllProductsService{
    @Autowired
    private ProductsRepository productsRepository;
    
    @Override
    public List<Products> getAllProducts(){
        List<Products> products = new ArrayList<>();
        List<Products> allProducts = productsRepository.findAll();
        for (Products  productObject : allProducts) {            
            products.add(productObject);            
        }        
        return products;
    }     
}

