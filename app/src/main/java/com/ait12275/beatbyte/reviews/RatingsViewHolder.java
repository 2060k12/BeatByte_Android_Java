package com.ait12275.beatbyte.reviews;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ait12275.beatbyte.databinding.RecyclerRatingReviewViewBinding;
import com.ait12275.beatbyte.databinding.RecyclerReviewViewBinding;
import com.ait12275.beatbyte.homepage.HomepageViewModel;
import com.ait12275.beatbyte.login.LoginViewModel;
import com.ait12275.beatbyte.users.UserProfileViewModel;
import com.squareup.picasso.Picasso;

public class RatingsViewHolder extends RecyclerView.ViewHolder{
    RecyclerReviewViewBinding reviewBinding;
    RecyclerRatingReviewViewBinding ratingBinding;
    UserProfileViewModel userProfileViewModel;
    HomepageViewModel homepageViewModel;
    LoginViewModel loginViewModel;



    public RatingsViewHolder(@NonNull RecyclerRatingReviewViewBinding ratingBinding) {
        super(ratingBinding.getRoot());
        this.ratingBinding = ratingBinding;

        // using view model to get access to user data
        userProfileViewModel = new UserProfileViewModel(new Application());

        homepageViewModel = new HomepageViewModel(new Application());
        loginViewModel = new LoginViewModel(new Application());
    }


    public void updateReviewsAlbums(Reviews reviews){
        ratingBinding.reviewBody.setText(reviews.getComment());
        ratingBinding.reviewRating.setRating(reviews.rating);
//        binding.reviewAlbumName.setText(userProfileViewModel.findById(LoginFragment.loggedInUserEmail).getUserName());
        ratingBinding.reviewUserName.setText(loginViewModel.findById(reviews.userID).getUserName().toString());
        Picasso.get().load(loginViewModel.findById(reviews.userID).getUserImage()).centerCrop().resize(200,200).into(ratingBinding.userImage);
    }


}
