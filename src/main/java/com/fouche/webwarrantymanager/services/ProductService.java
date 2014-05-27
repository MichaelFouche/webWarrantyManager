/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services;

import com.fouche.webwarrantymanager.domain.Products;
import com.fouche.webwarrantymanager.services.Services;
import java.util.List;

/**
 *
 * @author foosh
 */
public interface ProductService extends Services<Products, Long>{
    public List<Products> getAllProducts();
    public List<Products> getProductsWithModel(String model);
    public List<Products> getProductsMakePurchasedOn(String make, String purchasedOn);
    public List<Products> getProductsWithId(Long id);
    public List<Products> getProductsWithMake(String make);
}
