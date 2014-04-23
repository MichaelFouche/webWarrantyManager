/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.repository;

import com.fouche.webwarrantymanager.domain.products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author foosh
 */
@Repository
public interface productsRepository  extends JpaRepository<products, Long>{
    
}