/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.domain;

import java.util.Date;
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
    private long unitID;
    //Attributes
    private Date purchaseDate;
    private String sn;
    //Foreign Keys
    private String retailerID;
    private String warrantyID;
    private long productID;
    
    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name="album_id")
    
   private unit(){}
   
   //PARAMETERIZED CONSTRUCTOR
   private unit(Builder builder){
       unitID = builder.unitID;
       purchaseDate = builder.purchaseDate;
       retailerID = builder.retailerID;
       warrantyID = builder.warrantyID;
       productID = builder.productID;
   }
   //BUILDER CLASS
   public static class Builder{
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        //Primary Key
        private long unitID;
        //Attributes
        private Date purchaseDate;
        private String sn;
        //Foreign Keys
        private String retailerID;
        private String warrantyID;
        private long productID;
        
        public Builder(){}
        
        public Builder setUnitID(long value){
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
        public Builder setProductID(long value){
            productID = value;
            return this;
        }
        
        public unit build(){
            return new unit(this);
        }
       
   }
   //GETTERS
    public long getUnitID() {
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

    public long getProductID() {
        return productID;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (int) (this.unitID ^ (this.unitID >>> 32));
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
        if (this.unitID != other.unitID) {
            return false;
        }
        return true;
    }
   
            
}
