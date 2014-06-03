/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.Impl;

import com.fouche.webwarrantymanager.domain.Products;
import com.fouche.webwarrantymanager.domain.Unit;
import com.fouche.webwarrantymanager.repository.ProductsRepository;
import com.fouche.webwarrantymanager.repository.UnitRepository;
import com.fouche.webwarrantymanager.services.ProductService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author foosh
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductsRepository productsRepository;
    
    //@Autowired
    //private UnitRepository unitRepository;
    @Override
    public Products find(Long id) {
        return productsRepository.findOne(id);
    }
    
    @Override
    public Products persist(Products entity) {
        return productsRepository.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Products merge(Products entity) {

        if (entity.getProductID() != null) {
            return productsRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Products entity) {
        productsRepository.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Products> findAll() {
        return productsRepository.findAll(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Products> getAllProducts(){
        List<Products> products = new ArrayList<>();
        List<Products> allProducts = productsRepository.findAll();
        for (Products  productObject : allProducts) {            
            products.add(productObject);            
        }        
        return products;
    }  
    
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
    
    @Override
    public List<Products> getProductsWithId(Long id){
        List<Products> products = new ArrayList<>();
        List<Products> allProducts = productsRepository.findAll();
        for (Products  productObject : allProducts) { 
            if(productObject.getProductID().equals(id)){
                products.add(productObject);            
            }
        }        
        return products;
    }     
    
    @Override
    public List<Products> getProductsWithMake(String make){
        List<Products> products = new ArrayList<>();
        List<Products> allProducts = productsRepository.findAll();
        for (Products  productObject : allProducts) {   
            if(productObject.getMake().equals(make)){
                products.add(productObject);            
            }
        }        
        return products;
    }   
    
   /* @Override
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
    }  */   
}
