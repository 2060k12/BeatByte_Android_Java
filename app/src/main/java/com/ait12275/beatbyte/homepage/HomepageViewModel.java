package com.ait12275.beatbyte.homepage;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ait12275.beatbyte.albums.AlbumRepository;
import com.ait12275.beatbyte.albums.Albums;
import com.ait12275.beatbyte.artists.ArtistRepository;
import com.ait12275.beatbyte.artists.Artists;

import java.util.List;


public class HomepageViewModel extends AndroidViewModel {
private AlbumRepository albumRepository;
private ArtistRepository artistRepository;
private LiveData<List<Albums>> allAlbums;
private LiveData<List<Artists>> allArtists;


    public HomepageViewModel(@NonNull Application application) {
        super(application);

        // for Albums
        albumRepository = new AlbumRepository(application);
        allAlbums = albumRepository.getAllAlbums();

        // for Artists
        artistRepository = new ArtistRepository(application);
        allArtists = artistRepository.getAllArtists();


    }


    // For Albums

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
        return  allAlbums;
    }

    public Albums findById(int id){
        return albumRepository.findByID(id);
    }
    public Albums searchAlbums(String name){
        return albumRepository.searchAlbums(name);
    }



    // For artists

    public void insertArtist (Artists artists){artistRepository.insert(artists);}


    public LiveData<List<Artists>> getAllArtists() {
        return  artistRepository.getAllArtists();
    }

}
