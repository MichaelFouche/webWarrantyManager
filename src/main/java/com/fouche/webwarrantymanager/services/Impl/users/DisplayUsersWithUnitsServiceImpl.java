/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.Impl.users;

import com.fouche.webwarrantymanager.domain.Unit;
import com.fouche.webwarrantymanager.domain.Users;
import com.fouche.webwarrantymanager.repository.UnitRepository;
import com.fouche.webwarrantymanager.repository.UserRepository;
import com.fouche.webwarrantymanager.services.users.DisplayUsersWithUnitsService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Michael
 */
@Service
public class DisplayUsersWithUnitsServiceImpl implements DisplayUsersWithUnitsService{
    @Autowired
    private UserRepository userRepository;
    private UnitRepository unitRepository;
    
    @Override
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
    }
}
