/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.presentation.rest;

import com.fouche.webwarrantymanager.domain.Unit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author foosh
 */
@Controller
@RequestMapping(value = "api/unit")
public class UnitRestController {
 
    @RequestMapping(value = "create")
    @ResponseBody
    public String create(@RequestBody Unit unit) {
        System.out.println(" Create the Called ");
        return "";
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(@RequestBody Unit unit) {
        System.out.println(" Update Called ");
        return "";
    }
    
    @RequestMapping(value = "unit/{id}")
    @ResponseBody
    public Unit getPerson(@PathVariable String id) {
        System.out.println(" ID called ");
        return null;
    }
}
