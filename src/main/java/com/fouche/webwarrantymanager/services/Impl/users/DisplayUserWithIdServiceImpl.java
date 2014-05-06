/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.Impl.users;
import com.fouche.webwarrantymanager.domain.Users;
import com.fouche.webwarrantymanager.repository.UserRepository;
import com.fouche.webwarrantymanager.services.users.DisplayUserWithIdService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Michael
 */
@Service
public class DisplayUserWithIdServiceImpl implements DisplayUserWithIdService{
    @Autowired
    private UserRepository userRepository;
    
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
}
