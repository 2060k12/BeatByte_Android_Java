package com.ait12275.beatbyte.artists;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.ait12275.beatbyte.BeatByteRoomDatabase;
import com.ait12275.beatbyte.artists.Artists;
import com.ait12275.beatbyte.artists.ArtistsDAO;
import com.ait12275.beatbyte.users.Users;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ArtistRepository {

    private BeatByteRoomDatabase db;
    private Artists artists;
    private ArtistsDAO artistsDAO;
    private LiveData<List<Artists>> allArtists;

    public ArtistRepository(Application application) {
        db = BeatByteRoomDatabase.getDatabase(application);
        artistsDAO = db.artistsDAO();
        allArtists = artistsDAO.getALlArtists();
    }

    public void insert(Artists artists){

        BeatByteRoomDatabase.databaseWriteExecutor.execute(()->{
            artistsDAO.insert(artists);
        });
    }

    public void update (Artists artists){
        BeatByteRoomDatabase.databaseWriteExecutor.execute(()->{
            artistsDAO.update(artists);
        });
    }

    public void delete(Artists artists){
            BeatByteRoomDatabase.databaseWriteExecutor.execute(()->{
                artistsDAO.delete(artists);

            });
    }

    public LiveData<List<Artists>> getAllArtists() {
        return allArtists;
    }

    public Artists findById(Integer id){
        Callable c =()->{
          Artists  artist =  artistsDAO.findById(id);
          return artist;
        };

        Future<Artists> future = BeatByteRoomDatabase.databaseWriteExecutor.submit(c);

        try{
            artists = future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return artists;
    }
}
