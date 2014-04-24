/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.domain;

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
public class products {
    private static final long serialVersionUID = 1L;
    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Long productID;
    //Attributes
    private String make;
    private String model;
    
    private products(){}
    
    private products(Builder builder){        
        productID = builder.productID;
        make = builder.make;
        model = builder.model;
    }
    
    public static class Builder{
        private static final long serialVersionUID = 1L;
        //Primary Key
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long productID;  
        //Attributes
        private String make;
        private String model;
        
        public Builder(){}
        
        public Builder setProductID(Long value){
            productID = value;
            return this;
        }
        
        public Builder setMake(String value){
            make = value;
            return this;
        }
        
        public Builder setModel(String value){
            model = value;
            return this;
        }
        
        public products build(){
            return new products(this);
        }
            
    }
    

    //GETTERS
    public Long getProductID() {
        return productID;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.productID);
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
        final products other = (products) obj;
        if (!Objects.equals(this.productID, other.productID)) {
            return false;
        }
        return true;
    }

    

    

   
    
}
