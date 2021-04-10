package com.abhilasha.androidclass.recyclerview;
//Example of encapsulation
public class model {

    String username,password;

    public model(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public model() {
        //created blank constructor for creating object
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
