/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.products;

import com.fouche.webwarrantymanager.domain.Products;
import java.util.List;

/**
 *
 * @author foosh
 */
public interface DisplayProductsWithModelService {
    public List<Products> getProductsWithModel(String model);
}
