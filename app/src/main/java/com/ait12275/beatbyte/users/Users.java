package com.ait12275.beatbyte.users;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "USERS")
public class Users {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "USER_ID")
    int userId;
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
    @Ignore
    public Users() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
