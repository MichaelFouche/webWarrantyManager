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
public class unit {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long unitID;
     // needs to be long or string
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
    retailer retail;        
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="warranty_ID")
    warranty warr;        
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_ID")
    products prod;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_ID")
    user use;
    
   private unit(){}
   
   //PARAMETERIZED CONSTRUCTOR
   private unit(Builder builder){
       unitID = builder.unitID;
       purchaseDate = builder.purchaseDate;
       retailerID = builder.retailerID;
       warrantyID = builder.warrantyID;
       productID = builder.productID;
       userID = builder.userID;
       retail = builder.retail;
       warr = builder.warr;
       prod = builder.prod;
   }
   //BUILDER CLASS
   public static class Builder{
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long unitID;
        //Primary Key
        
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
        retailer retail;        
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name="warranty_ID")
        warranty warr;        
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name="product_ID")
        products prod;
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name="user_ID")
        user use;
        
        public Builder(){}
        
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
        public Builder setRetailer(retailer value){
            retail = value;
            return this;
        }
        public Builder setWarranty(warranty value){
            warr = value;
            return this;
        }
        public Builder setProduct(products value){
            prod = value;
            return this;
        }
        public Builder setUser(user value){
            use = value;
            return this;
        }
                
        public unit build(){
            return new unit(this);
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

    public retailer getRetail() {
        return retail;
    }

    public warranty getWarr() {
        return warr;
    }

    public products getProd() {
        return prod;
    }

    public user getUser() {
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
        final unit other = (unit) obj;
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
