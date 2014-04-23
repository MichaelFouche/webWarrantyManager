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
public class retailer {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //Primary key
    private long retailerID;
    //Attributes
    private String name;
    private String address;
    private String contact;
    
    private retailer(){}
    
    private retailer(Builder builder){
        retailerID = builder.retailerID;
        name = builder.name;
        address = builder.address;
        contact = builder.contact;    
    }
    
    public static class Builder{
        private static final long serialVersionUID=1L;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        //Primary key
        private long retailerID;
        //Attributes
        private String name;
        private String address;
        private String contact;
        
        public Builder(){}
        
        public Builder setRetailerID(long value){
            retailerID = value;
            return this;
        }
        public Builder setName(String value){
            name = value;
            return this;
        }
        public Builder setAddress(String value){
            address = value;
            return this;
        }
        public Builder setContact(String value){
            contact = value;
            return this;
        }
        public retailer build(){
            return new retailer(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (this.retailerID ^ (this.retailerID >>> 32));
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
        final retailer other = (retailer) obj;
        if (this.retailerID != other.retailerID) {
            return false;
        }
        return true;
    }
    
}
