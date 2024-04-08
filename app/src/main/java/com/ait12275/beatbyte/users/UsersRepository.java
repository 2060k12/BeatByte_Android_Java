package com.ait12275.beatbyte.users;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.ait12275.beatbyte.BeatByteRoomDatabase;
import com.ait12275.beatbyte.users.Users;
import com.ait12275.beatbyte.users.UsersDAO;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class UsersRepository {

    private BeatByteRoomDatabase db;
    private UsersDAO usersDAO;
    private Users users;
    private LiveData<List<Users>> allUsers;

    public UsersRepository(Application application){


        db = BeatByteRoomDatabase.getDatabase(application);
        usersDAO = db.usersDAO();
        allUsers = usersDAO.findAllUsers();


    }

    //to insert data in user table
    public void insert(Users users){
        BeatByteRoomDatabase.databaseWriteExecutor.execute(()->{

            usersDAO.insert(users);
        });
    }

    // to update existing data in the table
    public void update(Users users){
        BeatByteRoomDatabase.databaseWriteExecutor.execute(()->{
            usersDAO.update(users);
        });
    }

    //to delete data from the table
    public void delete(Users users){
        BeatByteRoomDatabase.databaseWriteExecutor.execute(()->{
            usersDAO.delete(users);
        });
    }

    // to get all users fro the table
    public LiveData<List<Users>> getAllUsers(){
         return allUsers;
    }

    // to get a user by their id in the table
    public Users findById(Integer id){
       Callable c = ()-> {
           Users users = usersDAO.findById(id);
           return users;
       };

       Future<Users> future = BeatByteRoomDatabase.databaseWriteExecutor.submit(c);
       try{
           users =future.get();
       } catch (ExecutionException e) {
           e.printStackTrace();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

       return  users;

    }




}
