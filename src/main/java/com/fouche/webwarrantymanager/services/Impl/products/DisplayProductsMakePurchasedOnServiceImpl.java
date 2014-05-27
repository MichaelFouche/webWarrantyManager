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
    
    
}