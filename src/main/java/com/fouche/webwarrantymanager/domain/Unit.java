/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.domain;

import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author foosh
 */
@Entity
public class Unit {
    private static final long serialVersionUID = 1L;
    //PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long unitID;
     
    //Attributes
    private String purchaseDate;
    private String sn;
    //Foreign Keys
    private Long retailerID;
    private Long warrantyID;
    private Long productID;   
    private Long userID;
    //objects
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="retailer_ID")
    Retailer retail;        
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="warranty_ID")
    Warranty warr;        
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_ID")
    Products prod;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_ID")
    Users use;
    
   private Unit(){}
   
   //PARAMETERIZED CONSTRUCTOR
   private Unit(Builder builder){
       unitID = builder.unitID;
       purchaseDate = builder.purchaseDate;
       sn = builder.sn;
       
       retailerID = builder.retailerID;
       warrantyID = builder.warrantyID;
       productID = builder.productID;
       userID = builder.userID;
       
       retail = builder.retail;
       warr = builder.warr;
       prod = builder.prod;
       use = builder.use;
   }
   //BUILDER CLASS
   public static class Builder{
        private static final long serialVersionUID = 1L;
        //Primary Key
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long unitID;
        //Attributes
        private String purchaseDate;
        private String sn;
        //Foreign Keys
        private Long retailerID;
        private Long warrantyID;
        private Long productID;
        private Long userID;
        //objects
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name="retailer_ID")
        Retailer retail;        
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name="warranty_ID")
        Warranty warr;        
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name="product_ID")
        Products prod;
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name="user_ID")
        Users use;
        
        public Builder(){}
        
        public Builder(String sn){
            this.sn = sn;
        }
        
        public Builder setUnitID(Long value){
            unitID = value;
            return this;
        }
        public Builder setPurchaseDate(String value){
            purchaseDate = value;
            return this;
        }
        public Builder setSn(String value){
            sn = value;
            return this;
        }
        public Builder setRetailerID(Long value){
            retailerID = value;
            return this;
        }
        public Builder setWarrantyID(Long value){
            warrantyID = value;
            return this;
        }
        public Builder setProductID(Long value){
            productID = value;
            return this;
        }
        public Builder setUserId(Long value){
            userID = value;
            return this;
        }
        public Builder setRetailer(Retailer value){
            retail = value;
            return this;
        }
        public Builder setWarranty(Warranty value){
            warr = value;
            return this;
        }
        public Builder setProduct(Products value){
            prod = value;
            return this;
        }
        public Builder setUser(Users value){
            use = value;
            return this;
        }
        public Builder user(Unit un){
            this.prod = un.prod;
            this.warr = un.warr ;
            this.use = un.use ;
            this.retail = un.retail ;
            this.userID = un.userID ;
            this.productID = un.productID ;
            this.warrantyID = un.warrantyID ;
            this.retailerID = un.retailerID ;
            this.sn = un.sn ;
            this.purchaseDate = un.purchaseDate ;
            this.unitID = un.unitID ;
            
            return this;
        }                
        public Unit build(){
            return new Unit(this);
        }
       
   }
   //GETTERS
    public Long getUnitID() {
        return unitID;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public String getSn() {
        return sn;
    }

    public Long getRetailerID() {
        return retailerID;
    }

    public Long getWarrantyID() {
        return warrantyID;
    }

    public Long getProductID() {
        return productID;
    }
    public Long getUserID() {
        return userID;
    }

    public Retailer getRetail() {
        return retail;
    }

    public Warranty getWarr() {
        return warr;
    }

    public Products getProd() {
        return prod;
    }

    public Users getUser() {
        return use;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.unitID);
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
        final Unit other = (Unit) obj;
        if (!Objects.equals(this.unitID, other.unitID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "unit{" + "unitID=" + unitID + '}';
    }      
}
