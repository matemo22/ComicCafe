package com.example.matemo.comiccafe;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Matemo on 11/7/2017.
 */

public class User implements Parcelable{
    int profileImage;
    String userEmail;

    public User(int profileImage, String userEmail)
    {
        this.profileImage = profileImage;
        this.userEmail = userEmail;
    }

    protected User(Parcel in) {
        profileImage = in.readInt();
        userEmail = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(profileImage);
        parcel.writeString(userEmail);
    }

    private void readFromParcel(Parcel in)
    {
        profileImage = in.readInt();
        userEmail = in.readString();
    }
}
