package com.example.matemo.comiccafe;

import android.os.Parcel;

import java.io.Serializable;

/**
 * Created by Matemo on 11/7/2017.
 */

public class User implements Serializable {
    int id, profileImage;
    String username, password, userEmail;

    public User(int id, String username, String password, String userEmail, int profileImage)
    {
        this.id = id;
        this.profileImage = profileImage;
        this.userEmail = userEmail;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
