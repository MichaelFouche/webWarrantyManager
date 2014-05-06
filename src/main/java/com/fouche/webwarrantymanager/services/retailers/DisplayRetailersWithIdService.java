/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.retailers;

import com.fouche.webwarrantymanager.domain.retailer;
import java.util.List;

/**
 *
 * @author foosh
 */
public interface DisplayRetailersWithIdService {
    public List<retailer> getRetailerWithId(String id);
}
