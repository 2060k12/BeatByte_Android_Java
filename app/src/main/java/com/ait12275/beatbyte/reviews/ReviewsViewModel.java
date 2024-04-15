package com.ait12275.beatbyte.reviews;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ait12275.beatbyte.users.Users;

import java.util.List;

public class ReviewsViewModel extends AndroidViewModel {

    private final ReviewsRepository reviewsRepository;
    private final LiveData<List<Reviews>> allReviews;

    public ReviewsViewModel(@NonNull Application application) {
        super(application);
        reviewsRepository = new ReviewsRepository(application);
        allReviews = reviewsRepository.allReviews;
    }


    // TODO: Implement the ViewModel
    public void insert(Reviews reviews ){
        reviewsRepository.insert(reviews);
    }


    //to update a user
    public void update(Reviews reviews){
        reviewsRepository.update(reviews);
    }



    // to delete a user
    public void delete (Reviews reviews){
        reviewsRepository.delete(reviews);
    }


    //to find a user by their Id
    public List<Reviews> getAllReviewsForAlbum(int albumId){
        return reviewsRepository.getAllReviewsForAlbum(albumId);
    }


    public List<Reviews> getAllReviewsFromUser(String userId){
        return reviewsRepository.getAllReviewsFromUser(userId);
    }
    public LiveData<List<Reviews>> getAllUsers() {
        return allReviews;
    }

}