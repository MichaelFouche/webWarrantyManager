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

/**
 *
 * @author foosh
 */
@Entity
public class unit {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //Primary Key
    private String unitID;
    //Attributes
    private Date purchaseDate;
    private String sn;
    //Foreign Keys
    private String retailerID;
    private String warrantyID;
    private String productID;   
    private String email;
    //objects
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="retailerID")
    retailer retail;        
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="warrantyID")
    warranty warr;        
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="productID")
    products prod;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="email")
    user use;
    
   private unit(){}
   
   //PARAMETERIZED CONSTRUCTOR
   private unit(Builder builder){
       unitID = builder.unitID;
       purchaseDate = builder.purchaseDate;
       retailerID = builder.retailerID;
       warrantyID = builder.warrantyID;
       productID = builder.productID;
       email = builder.email;
       retail = builder.retail;
       warr = builder.warr;
       prod = builder.prod;
   }
   //BUILDER CLASS
   public static class Builder{
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        //Primary Key
        private String unitID;
        //Attributes
        private Date purchaseDate;
        private String sn;
        //Foreign Keys
        private String retailerID;
        private String warrantyID;
        private String productID;
        private String email;
        //objects
        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name="retailerID")
        retailer retail;        
        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name="warrantyID")
        warranty warr;        
        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name="productID")
        products prod;
        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name="email")
        user use;
        
        public Builder(){}
        
        public Builder setUnitID(String value){
            unitID = value;
            return this;
        }
        public Builder setPurchaseDate(Date value){
            purchaseDate = value;
            return this;
        }
        public Builder setSn(String value){
            sn = value;
            return this;
        }
        public Builder setRetailerID(String value){
            retailerID = value;
            return this;
        }
        public Builder setWarrantyID(String value){
            warrantyID = value;
            return this;
        }
        public Builder setProductID(String value){
            productID = value;
            return this;
        }
        public Builder setEmail(String value){
            email = value;
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
    public String getUnitID() {
        return unitID;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public String getSn() {
        return sn;
    }

    public String getRetailerID() {
        return retailerID;
    }

    public String getWarrantyID() {
        return warrantyID;
    }

    public String getProductID() {
        return productID;
    }
    public String getEmail() {
        return email;
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

   
            
}
