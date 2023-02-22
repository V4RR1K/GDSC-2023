package com.recycleracoon.RecycleRacoonAPI.Model;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * User class represents user entity information
 * 
 * @author: Greg Lynskey, Mackenzie Wade
 * @category: Model Tier
 */
public class User {
    
    static final String FORMAT_STR = "User[id=%d, userName=%s, password=%s, addedLocations=%s, isAdmin=%b]";

    @JsonProperty("id")
    private int id;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;

    @JsonProperty("addedLocations") // TODO: update once location model is created
    private String addedLocations;

    @JsonProperty("isAdmin")
    private Boolean isAdmin;

    public User( 
        @JsonProperty("id") int id,
        @JsonProperty("userName") String userName,  
        @JsonProperty("password") String password, 
        @JsonProperty("addedLocations") String addedLocations, 
        @JsonProperty("isAdmin") Boolean isAdmin) {
        
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.addedLocations = addedLocations;
        this.isAdmin = isAdmin;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddedLocations() {
        return this.addedLocations;
    }

    public void setAddedLocations(String addedLocations) {
        this.addedLocations = addedLocations;
    }

    public Boolean isIsAdmin() {
        return this.isAdmin;
    }

    public Boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return String.format(FORMAT_STR, this.id, this.userName, this.password,
                this.addedLocations, this.isAdmin);
    }
}
