package com.ait12275.beatbyte.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ait12275.beatbyte.users.Users;
import com.ait12275.beatbyte.users.UsersRepository;

import java.util.List;

public class LoginViewModel extends AndroidViewModel{


    private final UsersRepository usersRepository;
    private final LiveData<List<Users>> allUsers;
    public LoginViewModel(@NonNull Application application) {
        super(application);
        usersRepository = new UsersRepository(application);
        allUsers = usersRepository.getAllUsers();

    }
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
        return usersRepository.findById(id);
    }

    // to get all the users
    public  LiveData<List<Users>> getAllUsers() {
        return allUsers;
    }



}
