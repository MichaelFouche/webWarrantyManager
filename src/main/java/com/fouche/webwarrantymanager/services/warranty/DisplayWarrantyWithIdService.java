/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.warranty;

import com.fouche.webwarrantymanager.domain.warranty;
import java.util.List;

/**
 *
 * @author foosh
 */
public interface DisplayWarrantyWithIdService {
    public List<warranty> getWarrantyWithId(String id);
}
