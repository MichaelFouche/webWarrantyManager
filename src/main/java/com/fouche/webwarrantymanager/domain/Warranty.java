/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author foosh
 */
@Entity
public class Warranty implements Serializable {
    private static final long serialVerionUID = 1L;
    //Primary KEY
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long warrantyID;
    
    //ATTRIBUTES
    private int replaceDuration;
    private int repairDuration;
    
    private Warranty(){}
    
    private Warranty(Builder builder){
        warrantyID = builder.warrantyID;
        replaceDuration = builder.replaceDuration;
        repairDuration = builder.repairDuration;
    }
    
    public static class Builder{
        private static final long serialVerionUID = 1L;        
        //Primary KEY
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long warrantyID;
        //ATTRIBUTES
        private int replaceDuration;
        private int repairDuration;
        
        public Builder setWarrantyID(Long value){
            warrantyID = value;
            return this;
        }
        public Builder setReplaceDuration(int value){
            replaceDuration = value;
            return this;
        }
        public Builder setRepairDuration(int value){
            repairDuration = value;
            return this;
        }
        public Warranty build(){
            return new Warranty(this);
        }
    }

    public static long getSerialVerionUID() {
        return serialVerionUID;
    }

    public Long getWarrantyID() {
        return warrantyID;
    }

    public int getReplaceDuration() {
        return replaceDuration;
    }

    public int getRepairDuration() {
        return repairDuration;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.warrantyID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Warranty other = (Warranty) obj;
        if (!Objects.equals(this.warrantyID, other.warrantyID)) {
            return false;
        }
        return true;
    }
    
}
