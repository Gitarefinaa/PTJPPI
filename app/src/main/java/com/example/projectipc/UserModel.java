package com.example.projectipc;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {
    @SerializedName("username")
    @Expose
private String username;
    @SerializedName("password")
    @Expose
private String password;

public void username(String username){
this.username=username;
    }
    public String getPassword(){
    return password;
    }
    public void setPassword(String password){
    this.password=password;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
    return username;
    }
}
