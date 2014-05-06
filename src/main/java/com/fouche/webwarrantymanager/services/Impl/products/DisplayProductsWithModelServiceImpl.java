/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.Impl.products;

import com.fouche.webwarrantymanager.domain.Products;
import com.fouche.webwarrantymanager.repository.ProductsRepository;
import com.fouche.webwarrantymanager.services.products.DisplayProductsWithModelService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Michael
 */
@Service
public class DisplayProductsWithModelServiceImpl implements DisplayProductsWithModelService{
    @Autowired
    private ProductsRepository productsRepository;
    
    @Override
    public List<Products> getProductsWithModel(String model){
        List<Products> products = new ArrayList<>();
        List<Products> allProducts = productsRepository.findAll();
        for (Products  productObject : allProducts) {  
            if(productObject.getModel().equals(model)){
                products.add(productObject);            
            }
        }        
        return products;
    }     
}