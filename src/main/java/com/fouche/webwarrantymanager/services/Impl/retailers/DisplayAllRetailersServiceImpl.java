/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services.Impl.retailers;

import com.fouche.webwarrantymanager.domain.Retailer;
import com.fouche.webwarrantymanager.repository.RetailerRepository;
import com.fouche.webwarrantymanager.services.retailers.DisplayAllRetailersService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Michael
 */
@Service
public class DisplayAllRetailersServiceImpl  implements DisplayAllRetailersService{
    @Autowired
    private RetailerRepository retailerRepository;
    
    @Override
    public List<Retailer> getAllRetailers(){
        List<Retailer> retailer = new ArrayList<>();
        List<Retailer> allRetailers = retailerRepository.findAll();
        for (Retailer  userObject : allRetailers) {            
            retailer.add(userObject);
            
        }        
        return retailer;
    }
}
