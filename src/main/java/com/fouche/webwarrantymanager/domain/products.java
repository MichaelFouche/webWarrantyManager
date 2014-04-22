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
public class products {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //Primary Key
    private String productID;
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
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        //Primary Key
        private String productID;
        //Attributes
        private String make;
        private String model;
        
        public Builder(){}
        
        public Builder productID(String value){
            productID = value;
            return this;
        }
        
        public Builder make(String value){
            make = value;
            return this;
        }
        
        public Builder model(String value){
            model = value;
            return this;
        }
        
        public products build(){
            return new products(this);
        }
            
    }
    

    //GETTERS
    public String getProductID() {
        return productID;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
    
}
