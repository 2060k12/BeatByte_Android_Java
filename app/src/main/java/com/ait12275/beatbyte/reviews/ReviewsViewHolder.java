package com.ait12275.beatbyte.reviews;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ait12275.beatbyte.databinding.RecyclerRatingReviewViewBinding;
import com.ait12275.beatbyte.databinding.RecyclerReviewViewBinding;
import com.ait12275.beatbyte.homepage.HomepageViewModel;
import com.ait12275.beatbyte.login.LoginFragment;
import com.ait12275.beatbyte.login.LoginViewModel;
import com.ait12275.beatbyte.users.UserProfileFragment;
import com.ait12275.beatbyte.users.UserProfileViewModel;
import com.squareup.picasso.Picasso;

public class ReviewsViewHolder extends RecyclerView.ViewHolder{
    RecyclerReviewViewBinding reviewBinding;
    RecyclerRatingReviewViewBinding ratingBinding;
    UserProfileViewModel userProfileViewModel;
    HomepageViewModel homepageViewModel;
    LoginViewModel loginViewModel;



    public ReviewsViewHolder(@NonNull RecyclerReviewViewBinding binding) {
        super(binding.getRoot());
        this.reviewBinding = binding;

        // using view model to get access to user data
        userProfileViewModel = new UserProfileViewModel(new Application());

        homepageViewModel = new HomepageViewModel(new Application());
        loginViewModel = new LoginViewModel(new Application());
    }


    public void updateReviews(Reviews reviews){
        reviewBinding.reviewBody.setText(reviews.getComment());
        reviewBinding.reviewRating.setRating(reviews.rating);
//        binding.reviewAlbumName.setText(userProfileViewModel.findById(LoginFragment.loggedInUserEmail).getUserName());
        reviewBinding.reviewAlbumName.setText(homepageViewModel.findById(reviews.albumId).getName());
        Picasso.get().load(homepageViewModel.findById(reviews.albumId).getAlbumArt()).resize(200, 200).centerCrop().into(reviewBinding.albumImage);
    }



}
