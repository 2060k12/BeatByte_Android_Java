package com.ait12275.beatbyte.reviews;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.ait12275.beatbyte.BeatByteRoomDatabase;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ReviewsRepository {

    BeatByteRoomDatabase db;
    Reviews reviews;
    ReviewsDAO reviewsDAO;
    LiveData<List<Reviews>> allReviews;

    public ReviewsRepository(Application application) {
        db = BeatByteRoomDatabase.getDatabase(application);
        reviewsDAO = db.reviewsDAO();
        allReviews = reviewsDAO.getALlReviews();
    }

    public void insert (Reviews reviews){
        BeatByteRoomDatabase.databaseWriteExecutor.execute(()->{
            reviewsDAO.insert(reviews);
        });
    }

    public void update (Reviews reviews){
        BeatByteRoomDatabase.databaseWriteExecutor.execute(()->{
            reviewsDAO.insert(reviews);
        });
    }

    public void delete (Reviews reviews){
        BeatByteRoomDatabase.databaseWriteExecutor.execute(()->{
            reviewsDAO.delete(reviews);
        });
    }

    public LiveData<List<Reviews>> getAllReviews(){
        return allReviews;
    }

    public List<Reviews> getAllReviewsForAlbum(int albumId){
        Callable c = ()->{
            List<Reviews> reviews = reviewsDAO.getAllReviewsForAlbum(albumId);
            return reviews;
        };
        Future<List<Reviews>> future  = BeatByteRoomDatabase.databaseWriteExecutor.submit(c);
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            // Handle exceptions appropriately, such as logging or returning an empty list
            throw new RuntimeException(e);
        }
    }


    public List<Reviews> getAllReviewsFromUser(String userId){
        Callable c = ()->{
            List<Reviews> reviews = reviewsDAO.getAllReviewsFromUser(userId);
            return reviews;
        };
        Future<List<Reviews>> future = BeatByteRoomDatabase.databaseWriteExecutor.submit(c);
        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            // Handle exceptions appropriately, such as logging or returning an empty list
            throw new RuntimeException(e);
        }
    }

    //ToDo:: Find by id


}
