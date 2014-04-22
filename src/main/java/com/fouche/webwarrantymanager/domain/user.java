/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.domain;

import java.rmi.server.UID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author foosh
 */
@Entity
public class user {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //PRIMARY KEY
    private String email;
    //ATTRIBUTES
    private String pwd;
    private String name;
    private String surname;
    private String contact;
    private String address;
    
    private user(){}
    
    private user(Builder builder){
        email = builder.email;
        pwd = builder.pwd;
        name = builder.name;
        surname = builder.surname;
        contact = builder.contact;
        address = builder.address;
    }
    
    public static class Builder{
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        //PRIMARY KEY
        private String email;
        //ATTRIBUTES
        private String pwd;
        private String name;
        private String surname;
        private String contact;
        private String address;
        
        public Builder(){}
        
        public Builder setEmail(String value){
            email = value;
            return this;
        }
        public Builder setPwd(String value){
            pwd = value;
            return this;
        }
        public Builder setName(String value){
            name = value;
            return this;
        }
        public Builder setSurname(String value){
            surname = value;
            return this;
        }
        public Builder setContact(String value){
            contact = value;
            return this;
        }
        public Builder setAddress(String value){
            address = value;
            return this;
        }
        public user build(){
            return new user(this);
        }
    }
}
