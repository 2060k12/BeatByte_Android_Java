package com.ait12275.beatbyte.reviews;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ait12275.beatbyte.R;
import com.ait12275.beatbyte.albums.RatingsAlbumsFragment;
import com.ait12275.beatbyte.databinding.AddReviewFragmentBinding;
import com.ait12275.beatbyte.databinding.RatingsAlbumsFragmentBinding;
import com.ait12275.beatbyte.login.LoginFragment;

import java.util.Objects;


public class addReviewFragment extends Fragment {

    public addReviewFragment() {
        // Required empty public constructor
    }
    AddReviewFragmentBinding binding;
    ReviewsViewModel reviewsViewModel;


    //TODO:: Fix submit button

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = AddReviewFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        reviewsViewModel = new ReviewsViewModel(new Application());

        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                float rating =binding.inputRatingBar.getRating();
                String review = Objects.requireNonNull(binding.textInputEditText.getText()).toString();
                String userId = LoginFragment.loggedInUserEmail;
                int albumId = RatingsAlbumsFragment.albumId;

                reviewsViewModel.insert(new Reviews(review,albumId,userId,rating));



            }
        });




    }
}