package com.ait12275.beatbyte.albums;

import android.app.Application;
import android.telecom.Call;

import androidx.lifecycle.LiveData;

import com.ait12275.beatbyte.BeatByteRoomDatabase;
import com.ait12275.beatbyte.albums.Albums;
import com.ait12275.beatbyte.albums.AlbumsDAO;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AlbumRepository {
    private BeatByteRoomDatabase db;
    private Albums albums;
    private AlbumsDAO albumsDAO;
    private LiveData<List<Albums>> allAlbums;


    public AlbumRepository(Application application) {
        db = BeatByteRoomDatabase.getDatabase(application);
        albumsDAO = db.albumsDAO();
        allAlbums = albumsDAO.getALlAlbums();
    }

    public void insert(Albums albums){
        BeatByteRoomDatabase.databaseWriteExecutor.execute(()->{
            albumsDAO.insert(albums);
        });
    }


    public void update(Albums albums){
        BeatByteRoomDatabase.databaseWriteExecutor.execute(()->{
            albumsDAO.update(albums);
        });
    }

    public void delete (Albums albums){
        BeatByteRoomDatabase.databaseWriteExecutor.execute(()->{
            albumsDAO.delete(albums);
        });
    }

    public LiveData<List<Albums>> getAllAlbums(){
        return  albumsDAO.getALlAlbums();
    }

    public Albums findByID (int id){
        Callable c = ()->{
            Albums albums = albumsDAO.findAlbumsByID(id);
            return  albums;
        };

        Future<Albums> future = BeatByteRoomDatabase.databaseWriteExecutor.submit(c);
        try{
            albums = future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  albums;
    }

}
