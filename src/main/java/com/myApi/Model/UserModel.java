package com.myApi.Model;

import com.myApi.Services.UserService;

public class UserModel {
    private String username;
    private String email;
    private String password;
    UserService userService = new UserService();

    public UserModel(){
    }

    public void SetEmail(String email){
        this.email = email;
    }

    public String GetEmail(){
        return this.email;
    }

    public void SetPassword(String password){
        this.password = password;
    }

    public String GetPassword(){
        return this.password;
    }

    public void SetUsername(String username){
        this.username = username;
    }

    public String GetUsername(){
        return this.username;
    }

    public void SetUser(String email, String username, String password){
        this.SetEmail(email);   
        this.SetPassword(password);
        this.SetUsername(username);   
    }

    public void Upload(){
        userService.registerUser(this.username, this.email, this.password);
    }
}
