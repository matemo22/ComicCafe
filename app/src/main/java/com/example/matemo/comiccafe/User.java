package com.example.matemo.comiccafe;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Matemo on 11/7/2017.
 */

public class User implements Parcelable{
    int profileImage;
    String username, password, userEmail;

    public User(String username, String password, String userEmail, int profileImage)
    {
        this.profileImage = profileImage;
        this.userEmail = userEmail;
        this.username = username;
        this.password = password;
    }

    protected User(Parcel in) {
        profileImage = in.readInt();
        userEmail = in.readString();
        username = in.readString();
        password = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(profileImage);
        parcel.writeString(userEmail);
        parcel.writeString(username);
        parcel.writeString(password);
    }

    private void readFromParcel(Parcel in)
    {
        profileImage = in.readInt();
        userEmail = in.readString();
        username = in.readString();
        password = in.readString();
    }
}
