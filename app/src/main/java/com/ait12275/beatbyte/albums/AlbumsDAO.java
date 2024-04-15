package com.ait12275.beatbyte.albums;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.ait12275.beatbyte.artists.Artists;

import java.util.List;

@Dao
public interface AlbumsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert (Albums albums);

    @Delete
    void delete(Albums albums);

    @Update
    void update (Albums albums);


    @Query("SELECT * FROM ALBUMS")
    LiveData<List<Albums>> getALlAlbums ();

    @Query("SELECT * FROM ALBUMS WHERE ALBUM_ID =:id")
    Albums findAlbumsByID (int id);

    @Query("SELECT * FROM albums WHERE name LIKE '%' || :name || '%'")
    Albums searchAlbums (String name);
}
