/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.Impl.unit;

import com.fouche.webwarrantymanager.domain.Unit;
import com.fouche.webwarrantymanager.repository.UnitRepository;
import com.fouche.webwarrantymanager.services.unit.DisplayUnitWithIdService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Michael
 */
@Service
public class DisplayUnitWithUserIdServiceImpl implements DisplayUnitWithIdService{
    @Autowired
    private UnitRepository unitRepository;
    
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
}
