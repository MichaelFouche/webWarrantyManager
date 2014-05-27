/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.Impl;

import com.fouche.webwarrantymanager.domain.Unit;
import com.fouche.webwarrantymanager.repository.UnitRepository;
import com.fouche.webwarrantymanager.services.UnitsService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author foosh
 */
@Service
public class UnitsServiceImpl implements UnitsService{
    
    @Autowired
    private UnitRepository unitRepository;
    
     
    @Override
    public Unit find(Long id) {
        return unitRepository.findOne(id);
    }
    
    @Override
    public Unit persist(Unit entity) {
        return unitRepository.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Unit merge(Unit entity) {

        if (entity.getProductID() != null) {
            return unitRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Unit entity) {
        unitRepository.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Unit> findAll() {
        return unitRepository.findAll(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Unit> getAllUnits(){
        List<Unit> unito = new ArrayList<>();
        List<Unit> allUnits = unitRepository.findAll();
        for (Unit  unitObject : allUnits) {            
            unito.add(unitObject);            
        }        
        return unito;
    }    
    
    @Override
    public List<Unit> getUnitWithSn(String sn){
        List<Unit> unito = new ArrayList<>();
        List<Unit> allUnits = unitRepository.findAll();
        for (Unit  unitObject : allUnits) {    
            if(unitObject.getSn().equals(sn)){
            unito.add(unitObject);            
            }
        }        
        return unito;
    }   
    
    @Override
    public List<Unit> getUnitWithId(Long id){
        List<Unit> unito = new ArrayList<>();
        List<Unit> allUnits = unitRepository.findAll();
        for (Unit  unitObject : allUnits) {   
            if(unitObject.getUserID().equals(id)){
            unito.add(unitObject);            
            }
        }        
        return unito;
    }
    
    @Override
    public List<Unit> getUnitsPurchasedOn(String date){
        List<Unit> unito = new ArrayList<>();
        List<Unit> allUnits = unitRepository.findAll();
        for (Unit  unitObject : allUnits) {    
            if(unitObject.getPurchaseDate().equals(date)){
            unito.add(unitObject);            
            }
        }        
        return unito;
    }   
    
    @Override
    public List<Unit> getUnitsWithRetailerId(Long id){
        List<Unit> unito = new ArrayList<>();
        List<Unit> allUnits = unitRepository.findAll();
        for (Unit  unitObject : allUnits) {  
            if(unitObject.getRetailerID().equals(id)){
            unito.add(unitObject);            
            }
        }        
        return unito;
    }   
    
    @Override
    public List<Unit> getUnitsWithUserId(Long id){
        List<Unit> unito = new ArrayList<>();
        List<Unit> allUnits = unitRepository.findAll();
        for (Unit  unitObject : allUnits) {   
            if(unitObject.getUserID().equals(id)){
            unito.add(unitObject);            
            }
        }        
        return unito;
    }  
}
