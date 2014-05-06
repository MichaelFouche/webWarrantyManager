/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.Impl.warranty;

import com.fouche.webwarrantymanager.domain.Warranty;
import com.fouche.webwarrantymanager.repository.WarrantyRepository;
import com.fouche.webwarrantymanager.services.warranty.DisplayAllWarrantyService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Michael
 */
@Service
public class DisplayAllWarrantyServiceImpl implements DisplayAllWarrantyService{
    @Autowired
    private WarrantyRepository warrantyRepository;
    
    @Override
    public List<Warranty> getAllWarranty(){
        List<Warranty> warranty = new ArrayList<>();
        List<Warranty> allWarranty = warrantyRepository.findAll();
        for (Warranty  warrantyObject : allWarranty) {            
            warranty.add(warrantyObject);            
        }        
        return warranty;
    }     
}
