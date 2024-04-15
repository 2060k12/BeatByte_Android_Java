package com.ait12275.beatbyte.reviews;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ReviewsDAO {

    @Insert
    public void insert (Reviews reviews);

    @Delete
    public void delete (Reviews reviews);

    @Update
    public void update(Reviews reviews);

    @Query("SELECT * FROM REVIEWS_TABLE WHERE ID=:id")
    Reviews findByID(int id);

    @Query("SELECT * FROM REVIEWS_TABLE")
    LiveData<List<Reviews>> getALlReviews();

    // this gives all the reviews of a particular album;
    @Query("SELECT * FROM REVIEWS_TABLE where ALBUM_ID =:albumId")
    List<Reviews> getAllReviewsForAlbum(int albumId);

    // this gives all the reviews of an artist
    @Query("SELECT * FROM REVIEWS_TABLE where USER_ID=:userID")
    List<Reviews> getAllReviewsFromUser(String userID);

}
