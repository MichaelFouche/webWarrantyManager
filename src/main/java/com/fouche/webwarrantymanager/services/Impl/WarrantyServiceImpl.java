/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.Impl;

import com.fouche.webwarrantymanager.domain.Warranty;
import com.fouche.webwarrantymanager.repository.WarrantyRepository;
import com.fouche.webwarrantymanager.services.WarrantyService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author foosh
 */
@Service
public class WarrantyServiceImpl implements WarrantyService{
    @Autowired
    private WarrantyRepository warrantyRepository;
    
    @Override
    public Warranty find(Long id) {
        return warrantyRepository.findOne(id);
    }
    
    @Override
    public Warranty persist(Warranty entity) {
        return warrantyRepository.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Warranty merge(Warranty entity) {

        if (entity.getWarrantyID() != null) {
            return warrantyRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Warranty entity) {
        warrantyRepository.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Warranty> findAll() {
        return warrantyRepository.findAll(); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
    @Override
    public List<Warranty> getAllWarranty(){
        List<Warranty> warranty = new ArrayList<>();
        List<Warranty> allWarranty = warrantyRepository.findAll();
        for (Warranty  warrantyObject : allWarranty) {            
            warranty.add(warrantyObject);            
        }        
        return warranty;
    }    
    
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
