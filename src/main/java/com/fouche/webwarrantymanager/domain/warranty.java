/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author foosh
 */
@Entity
public class warranty {
    private static final long serialVerionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //Primary KEY
    private long warrantyID;
    //ATTRIBUTES
    private int replaceDuration;
    private int repairDuration;
    
    private warranty(){}
    
    private warranty(Builder builder){
        warrantyID = builder.warrantyID;
        replaceDuration = builder.replaceDuration;
        repairDuration = builder.repairDuration;
    }
    
    public static class Builder{
        private static final long serialVerionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        //Primary KEY
        private long warrantyID;
        //ATTRIBUTES
        private int replaceDuration;
        private int repairDuration;
        
        public Builder setWarrantyID(long value){
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
        public warranty build(){
            return new warranty(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (int) (this.warrantyID ^ (this.warrantyID >>> 32));
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
        final warranty other = (warranty) obj;
        if (this.warrantyID != other.warrantyID) {
            return false;
        }
        return true;
    }
    
}
