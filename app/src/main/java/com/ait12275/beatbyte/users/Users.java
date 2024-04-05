package com.ait12275.beatbyte.users;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "USERS")
public class Users {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "USERID")
    Integer userId;
    @ColumnInfo(name = "USERNAME")
    String userName;

    @ColumnInfo(name = "PASSWORD")
    String password;

    @ColumnInfo(name = "EMAIL")
    String email;

    public Users(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;}
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
