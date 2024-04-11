package com.ait12275.beatbyte.users;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UsersDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Users users);

    @Update
    void update(Users users);

    @Delete
    void delete(Users users);

    @Query("SELECT * FROM USERS")
    LiveData<List<Users>> findAllUsers();

    @Query("SELECT * FROM USERS WHERE USER_ID=:id")
    Users findById(Integer id);

    @Query("SELECT * FROM USERS WHERE EMAIL=:email AND PASSWORD =:password ")
    Users checkLogIn(String email, String password);




}
