package com.ait12275.beatbyte.users;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ait12275.beatbyte.login.LoginViewModel;
import com.ait12275.beatbyte.reviews.ReviewsViewModel;
import com.ait12275.beatbyte.databinding.UserprofileFragmentBinding;
import com.ait12275.beatbyte.homepage.AlbumsRecyclerViewAdapter;
import com.ait12275.beatbyte.login.LoginFragment;
import com.ait12275.beatbyte.reviews.Reviews;
import com.ait12275.beatbyte.reviews.ReviewsRecyclerViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UserProfileFragment extends Fragment {

    String loggedInUser = LoginFragment.loggedInUserEmail;
    UsersRepository usersRepository;
    private UserProfileViewModel mViewModel;
    UserprofileFragmentBinding binding ;
    private ReviewsViewModel reviewsViewModel;

    public static UserProfileFragment newInstance() {
        return new UserProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding=  UserprofileFragmentBinding.inflate(inflater, container, false);

        return  binding.getRoot();
    }



    public void reviewChip(){
        binding.reviewsScrollView.setVisibility(View.VISIBLE);
        binding.favouratesScrollView.setVisibility(View.GONE);
        binding.settingScrollView.setVisibility(View.GONE);

        binding.reviewsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false ));
        binding.reviewsRecyclerView.setHasFixedSize(true);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UserProfileViewModel.class);
        reviewsViewModel = new ViewModelProvider(this).get(ReviewsViewModel.class);
        Users ourUser = mViewModel.usersRepository.findById(loggedInUser);
        Picasso.get().load(ourUser.userImage).centerCrop().resize(200,200).into(binding.imageView);
        binding.nameText.setText(ourUser.userName);


        ReviewsRecyclerViewAdapter reviewsRecyclerViewAdapterAdapter = new ReviewsRecyclerViewAdapter();
        binding.reviewsRecyclerView.setAdapter(reviewsRecyclerViewAdapterAdapter);
        reviewChip();



        binding.yourReviewsChip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               reviewChip();


            }
        });

        final Observer<List<Reviews>> reviewsObserver = new Observer<List<Reviews>>() {
            @Override
            public void onChanged(List<Reviews> reviews) {


//                reviewsRecyclerViewAdapterAdapter.submitList(reviews);
                reviewsRecyclerViewAdapterAdapter.submitList(reviewsViewModel.getAllReviewsFromUser(loggedInUser));

            }
        };

        reviewsViewModel.getAllUsers().observe(getViewLifecycleOwner(),reviewsObserver);


        binding.favouratesChip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.reviewsScrollView.setVisibility(View.GONE);
                binding.favouratesScrollView.setVisibility(View.VISIBLE);
                binding.settingScrollView.setVisibility(View.GONE);
            }
        });

        binding.settingChip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.reviewsScrollView.setVisibility(View.GONE);
                binding.favouratesScrollView.setVisibility(View.GONE);
                binding.settingScrollView.setVisibility(View.VISIBLE);
            }
        });


    }
}

