/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.Impl;

import com.fouche.webwarrantymanager.domain.Unit;
import com.fouche.webwarrantymanager.domain.Users;
import com.fouche.webwarrantymanager.repository.UnitRepository;
import com.fouche.webwarrantymanager.repository.UserRepository;
import com.fouche.webwarrantymanager.services.UsersService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author foosh
 */
@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    private UserRepository userRepository;
    
  /*  @Autowired
    private UnitRepository unitRepository;
    */
    @Override
    public Users find(Long id) {
        return userRepository.findOne(id);
    }
    
    @Override
    public Users persist(Users entity) {
        return userRepository.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users merge(Users entity) {

        if (entity.getUserID() != null) {
            return userRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Users entity) {
        userRepository.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Users> findAll() {
        return userRepository.findAll(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Users> getAllUsers() {
        List<Users> user = new ArrayList<>();
        List<Users> allUsers = userRepository.findAll();
        for (Users  userObject : allUsers) {            
            user.add(userObject);
            
        }        
        return user;
    }
    
    @Override
    public List<Users> getUserWithId(Long id) {
        List<Users> user = new ArrayList<>();
        List<Users> allUsers = userRepository.findAll();
        for (Users  userObject : allUsers) {  
            if(userObject.getUserID().equals(id)){
                user.add(userObject);
            } 
        }        
        return user;
    }
    
    @Override
    public List<Users> getUserWithSurname(String surname) {
        List<Users> user = new ArrayList<>();
        List<Users> allUsers = userRepository.findAll();
        for (Users  userObject : allUsers) {  
            if(userObject.getSurname().equals(surname)){
                user.add(userObject);
            } 
        }        
        return user;
    }
    
    
    
  /*  @Override
    public List<Users> getUsersWithUnits() {
        List<Users> user = new ArrayList<>();
        List<Unit> allUnits = unitRepository.findAll();
        List<Users> allUsers = userRepository.findAll();
        for (Unit  unitObject : allUnits) { //Loop through all the units 
            for (Users  userObject : allUsers) { //loop through all the users
                if(userObject.getUserID().equals(unitObject.getUserID())){ //check whether the unit's user id is equal to the user id in the current loop itteration
                    user.add(userObject);
                    break;//Only one user can belong to a unit, therefore break and continue to next unit
                } 
            }    
        }
        return user;
    }*/
}
