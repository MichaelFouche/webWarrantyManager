/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.Impl.users;
import com.fouche.webwarrantymanager.domain.Users;
import com.fouche.webwarrantymanager.repository.UserRepository;
import com.fouche.webwarrantymanager.services.users.DisplayAllUsersService;
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
    private UserRepository userRepository;
    
    @Override
    public List<Users> getAllUsers() {
        List<Users> user = new ArrayList<>();
        List<Users> allUsers = userRepository.findAll();
        for (Users  userObject : allUsers) {            
            user.add(userObject);
            
        }        
        return user;
    }
    
}
