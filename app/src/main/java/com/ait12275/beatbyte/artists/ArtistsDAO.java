package com.ait12275.beatbyte.artists;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ArtistsDAO {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(Artists artists);

    @Update
    void update(Artists artists);

    @Delete
    void delete(Artists artists);

    @Query("SELECT * FROM ARTISTS")
    LiveData<List<Artists>> getALlArtists();

    @Query("SELECT * FROM ARTISTS WHERE ARTIST_ID=:id")
    Artists findById(Integer id);



}
