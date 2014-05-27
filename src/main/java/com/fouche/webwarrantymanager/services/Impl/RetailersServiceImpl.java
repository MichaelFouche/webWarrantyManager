/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.Impl;


import com.fouche.webwarrantymanager.domain.Retailer;
import com.fouche.webwarrantymanager.repository.RetailerRepository;
import com.fouche.webwarrantymanager.services.RetailersService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author foosh
 */
@Service
public class RetailersServiceImpl implements RetailersService{
    @Autowired
    private RetailerRepository retailerRepository;
    
    @Override
    public Retailer find(Long id) {
        return retailerRepository.findOne(id);
    }
    
    @Override
    public Retailer persist(Retailer entity) {
        return retailerRepository.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Retailer merge(Retailer entity) {

        if (entity.getRetailerID() != null) {
            return retailerRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Retailer entity) {
        retailerRepository.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Retailer> findAll() {
        return retailerRepository.findAll(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Retailer> getAllRetailers(){
        List<Retailer> retailer = new ArrayList<>();
        List<Retailer> allRetailers = retailerRepository.findAll();
        for (Retailer  userObject : allRetailers) {            
            retailer.add(userObject);
            
        }        
        return retailer;
    }
    
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
    
    @Override
    public List<Retailer> getRetailersWithId(Long id){
        List<Retailer> retailer = new ArrayList<>();
        List<Retailer> allRetailers = retailerRepository.findAll();
        for (Retailer  userObject : allRetailers) {    
            if(userObject.getRetailerID().equals(id)){
            retailer.add(userObject);
            }            
        }        
        return retailer;
    }
}
