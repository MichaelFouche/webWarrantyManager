/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.Impl.warranty;

import com.fouche.webwarrantymanager.domain.Warranty;
import com.fouche.webwarrantymanager.repository.WarrantyRepository;
import com.fouche.webwarrantymanager.services.warranty.DisplayAllWarrantyService;
import com.fouche.webwarrantymanager.services.warranty.DisplayWarrantyWithIdService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Michael
 */
public class DisplayWarrantyWithIdServiceImpl implements DisplayWarrantyWithIdService{
    @Autowired
    private WarrantyRepository warrantyRepository;
    
    @Override
    public List<Warranty> getWarrantyWithId(Long id){
        List<Warranty> warranty = new ArrayList<>();
        List<Warranty> allWarranty = warrantyRepository.findAll();
        for (Warranty  warrantyObject : allWarranty) {  
            if(warrantyObject.getWarrantyID().equals(id)){
            warranty.add(warrantyObject);            
            }
        }        
        return warranty;
    }     
}
