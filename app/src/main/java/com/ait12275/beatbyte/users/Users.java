package com.ait12275.beatbyte.users;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "USERS")
public class Users implements Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "EMAIL")
    String email;

    @ColumnInfo(name = "USERNAME")
    String userName;

    @ColumnInfo(name = "PASSWORD")
    String password;


    @ColumnInfo(name = "USER_IMAGE")
    String userImage;


    public Users(@NonNull String email, String userName, String password, String userImage) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.userImage = userImage;
    }

    @Ignore
    public Users() {
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    @Override
    public String toString() {
        return "Users{" +
                "email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", UserImage='" + userImage + '\'' +
                '}';
    }
}
