/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.users;

import com.fouche.webwarrantymanager.domain.users;
import java.util.List;

/**
 *
 * @author foosh
 */
public interface DisplayUserWithIDService {
    public List<users> getUserWithID(String id);
}
