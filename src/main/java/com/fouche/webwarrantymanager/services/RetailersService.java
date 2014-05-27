/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services;

import com.fouche.webwarrantymanager.domain.Retailer;
import java.util.List;

/**
 *
 * @author foosh
 */
public interface RetailersService extends Services<Retailer, Long>{
    public List<Retailer> getRetailersWithName(String name);
    public List<Retailer> getAllRetailers();
    public List<Retailer> getRetailersWithId(Long id);
}
