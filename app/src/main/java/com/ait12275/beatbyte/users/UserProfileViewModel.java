package com.ait12275.beatbyte.users;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ait12275.beatbyte.albums.Albums;

import java.util.List;

public class UserProfileViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel

    UsersRepository usersRepository;
    private LiveData<List<Users>> allUsers;

    public UserProfileViewModel(@NonNull Application application) {
        super(application);
        usersRepository = new UsersRepository(application);
        allUsers = usersRepository.getAllUsers();
    }


    public void insert(Users users) {
        usersRepository.insert(users);
    }

    public void update(Users users) {
        usersRepository.update(users);
    }

    public void delete(Users users) {
        usersRepository.delete(users);
    }

    public LiveData<List<Users>> getAllUsers() {
        return allUsers;
    }

    public Users findById(String email) {
        return usersRepository.findById(email);
    }
}