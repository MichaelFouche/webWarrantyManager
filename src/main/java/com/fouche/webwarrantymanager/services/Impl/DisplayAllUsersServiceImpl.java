/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.Impl;
import com.fouche.webwarrantymanager.domain.users;
import com.fouche.webwarrantymanager.repository.userRepository;
import com.fouche.webwarrantymanager.services.DisplayAllUsersService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author foosh
 */
@Service
public class DisplayAllUsersServiceImpl implements DisplayAllUsersService{
    @Autowired
    private userRepository userRepository;
    
    @Override
    public List<users> getAllUsers() {
        List<users> user = new ArrayList<>();
        List<users> allUsers = userRepository.findAll();
        for (users  userObject : allUsers) {            
            user.add(userObject);
            
        }        
        return user;
    }
    
}
