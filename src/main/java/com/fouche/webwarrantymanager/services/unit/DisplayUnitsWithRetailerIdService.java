/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.unit;

import com.fouche.webwarrantymanager.domain.unit;
import java.util.List;

/**
 *
 * @author foosh
 */
public interface DisplayUnitsWithRetailerIdService {
    public List<unit> getUnitsWithRetailerId(String id);
}
