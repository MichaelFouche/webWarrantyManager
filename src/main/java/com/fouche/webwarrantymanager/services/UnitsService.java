/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.services;

import com.fouche.webwarrantymanager.domain.Unit;
import java.util.List;

/**
 *
 * @author foosh
 */
public interface UnitsService extends Services<Unit, Long> {
    public List<Unit> getAllUnits();
    public List<Unit> getUnitWithId(Long id);
    public List<Unit> getUnitWithSn(String sn);
    public List<Unit> getUnitsPurchasedOn(String date);
    public List<Unit> getUnitsWithRetailerId(Long id);
    public List<Unit> getUnitsWithUserId(Long id);
}
