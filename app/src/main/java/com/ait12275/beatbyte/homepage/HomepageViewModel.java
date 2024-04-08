package com.ait12275.beatbyte.homepage;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ait12275.beatbyte.albums.AlbumRepository;
import com.ait12275.beatbyte.albums.Albums;

import java.util.List;


public class HomepageViewModel extends AndroidViewModel {
private AlbumRepository albumRepository;
private LiveData<List<Albums>> allAlbums;

    public HomepageViewModel(@NonNull Application application) {
        super(application);
        albumRepository = new AlbumRepository(application);
        allAlbums = albumRepository.getAllAlbums();
    }

    public void insert(Albums albums){
        albumRepository.insert(albums);
    }
    public void update(Albums albums){
        albumRepository.update(albums);
    }
    public void delete(Albums albums){
        albumRepository.delete(albums);
    }

    public LiveData<List<Albums>> getAllAlbums (){
        return  albumRepository.getAllAlbums();
    }

    public Albums findById(int id){
        return albumRepository.findByID(id);
    }


}
