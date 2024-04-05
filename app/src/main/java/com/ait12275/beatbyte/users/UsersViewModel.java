package com.ait12275.beatbyte.users;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ait12275.beatbyte.UsersRepository;

import java.util.List;

public class UsersViewModel extends AndroidViewModel {


    private UsersRepository usersRepository;
    private LiveData<List<Users>> allusers;
    public UsersViewModel(@NonNull Application application) {
        super(application);
        usersRepository = new UsersRepository(application);
        allusers = usersRepository.getAllUsers();
    }
    // TODO: Implement the ViewModel


    // to insert a user
    public void insert(Users users){
        usersRepository.insert(users);
    }


    //to update a user
    public void update(Users users){
        usersRepository.update(users);
    }



    // to delete a user
    public void delete (Users users){
        usersRepository.delete(users);
    }


    //to find a user by their Id
    public Users findById(Integer id){
        Users users = usersRepository.findById(id);
        return users;
    }

    // to get all the users
    public  LiveData<List<Users>> getAllusers() {
        return allusers;
    }
}