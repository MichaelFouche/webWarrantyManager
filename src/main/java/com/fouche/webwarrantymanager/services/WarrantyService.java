/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services;

import com.fouche.webwarrantymanager.domain.Warranty;
import java.util.List;

/**
 *
 * @author foosh
 */
public interface WarrantyService extends Services<Warranty, Long>{
     public List<Warranty> getWarrantyWithId(Long id);
     public List<Warranty> getAllWarranty();
}
