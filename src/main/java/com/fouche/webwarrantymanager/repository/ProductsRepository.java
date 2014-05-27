/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.repository;

import com.fouche.webwarrantymanager.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author foosh
 */

public interface ProductsRepository  extends JpaRepository<Products, Long>{
    
}