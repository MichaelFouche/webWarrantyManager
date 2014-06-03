/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services;

import com.fouche.webwarrantymanager.domain.Users;
import java.util.List;

/**
 *
 * @author foosh
 */
public interface UsersService extends Services<Users, Long>{
    //public List<Users> getUsersWithUnits();
    public List<Users> getUserWithSurname(String surname);
    public List<Users> getUserWithId(Long id);
    public List<Users> getAllUsers();
}
