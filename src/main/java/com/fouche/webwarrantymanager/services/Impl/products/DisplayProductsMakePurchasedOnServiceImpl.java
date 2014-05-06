/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.Impl.products;

import com.fouche.webwarrantymanager.domain.Products;
import com.fouche.webwarrantymanager.domain.Unit;
import com.fouche.webwarrantymanager.repository.ProductsRepository;
import com.fouche.webwarrantymanager.repository.UnitRepository;
import com.fouche.webwarrantymanager.services.products.DisplayProductsMakePurchasedOnService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Michael
 */
@Service
public class DisplayProductsMakePurchasedOnServiceImpl implements DisplayProductsMakePurchasedOnService{
    @Autowired
    private ProductsRepository productsRepository;
    private UnitRepository unitRepository;
    
    @Override
    public List<Products> getProductsMakePurchasedOn(String make, String purchasedOn){
        List<Products> products = new ArrayList<>();
        List<Products> allProducts = productsRepository.findAll();
        List<Unit> allUnits = unitRepository.findAll();        
        for (Products  productObject : allProducts) {  
            for(Unit unitObject : allUnits){
                if(productObject.getMake().equals(make)&&unitObject.getPurchaseDate().equals(purchasedOn)){
                products.add(productObject);   
                }
            }
                     
        }        
        return products;
    }     
}