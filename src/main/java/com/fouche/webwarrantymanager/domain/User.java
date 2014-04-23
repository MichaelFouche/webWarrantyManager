/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fouche.webwarrantymanager.domain;

import java.rmi.server.UID;
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
public class User {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //PRIMARY KEY
    private Long userID;    
    //ATTRIBUTES
    private String email;
    private String pwd;
    private String name;
    private String surname;
    private String contact;
    private String address;
    
    private User(){}
    
    private User(Builder builder){
        userID = builder.userID;
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
        private Long userID;    
        //ATTRIBUTES
        private String email;
        private String pwd;
        private String name;
        private String surname;
        private String contact;
        private String address;
        
        public Builder(){}
        
        public Builder setUserID(Long value){
            userID = value;
            return this;
        }
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
        public User build(){
            return new User(this);
        }
    }


    public Long getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.userID);
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
        final User other = (User) obj;
        if (!Objects.equals(this.userID, other.userID)) {
            return false;
        }
        return true;
    }

   

    
    
}
