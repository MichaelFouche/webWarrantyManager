/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.presentation;

import com.fouche.webwarrantymanager.domain.Unit;
import com.fouche.webwarrantymanager.services.UnitsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author foosh
 */
@Controller
public class UnitController {
    @Autowired
    private UnitsService unitsService;
    
    @RequestMapping(value = "unit")
    @ResponseBody
    public Unit getUnit() {
        Unit u = null;
        List<Unit> unit = unitsService.findAll();

        System.out.println(" THE COllection Size" + unit.size());

        if (unit.size() > 0) {
            u = unit.get(0);

        }

        return u;
    }
}
