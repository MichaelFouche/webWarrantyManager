/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.Impl.retailers;

import com.fouche.webwarrantymanager.domain.Retailer;
import com.fouche.webwarrantymanager.repository.RetailerRepository;
import com.fouche.webwarrantymanager.services.retailers.DisplayAllRetailersService;
import com.fouche.webwarrantymanager.services.retailers.DisplayRetailersWithNameService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Michael
 */
@Service
public class DisplayRetailerWithNameServiceImpl implements DisplayRetailersWithNameService{
    @Autowired
    private RetailerRepository retailerRepository;
    
    @Override
    public List<Retailer> getRetailersWithName(String name){
        List<Retailer> retailer = new ArrayList<>();
        List<Retailer> allRetailers = retailerRepository.findAll();
        for (Retailer  userObject : allRetailers) {   
            if(userObject.getName().equals(name)){
            retailer.add(userObject);
            }
        }        
        return retailer;
    }
}
