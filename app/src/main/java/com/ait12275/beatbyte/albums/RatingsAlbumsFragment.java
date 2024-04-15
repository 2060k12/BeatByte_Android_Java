package com.ait12275.beatbyte.albums;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ait12275.beatbyte.R;
import com.ait12275.beatbyte.databinding.AddReviewFragmentBinding;
import com.ait12275.beatbyte.databinding.RatingsAlbumsFragmentBinding;
import com.ait12275.beatbyte.reviews.RatingRecyclerViewAdapter;
import com.ait12275.beatbyte.reviews.ReviewsRecyclerViewAdapter;
import com.ait12275.beatbyte.reviews.ReviewsViewModel;

public class RatingsAlbumsFragment extends Fragment {


    RatingsAlbumsFragmentBinding binding;
    ReviewsViewModel reviewsViewModel;
    public static int albumId;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
         binding = RatingsAlbumsFragmentBinding.inflate(inflater, container, false);
         return  binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        RatingsAlbumsFragmentArgs args = RatingsAlbumsFragmentArgs.fromBundle(getArguments());
        albumId = args.getAlbumId();

        reviewsViewModel = new ViewModelProvider(this).get(ReviewsViewModel.class);
        RatingRecyclerViewAdapter ratingRecyclerViewAdapter = new RatingRecyclerViewAdapter();
        binding.recyclerView.setAdapter(ratingRecyclerViewAdapter);
        ratingRecyclerViewAdapter.submitList(reviewsViewModel.getAllReviewsForAlbum(albumId));

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.recyclerView.setHasFixedSize(true);


        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the layout associated with addReviewFragmentBinding
                View contentView = LayoutInflater.from(getContext()).inflate(R.layout.add_review_fragment, null);

                // Create a PopupWindow and set its content view
                PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

                // Show the PopupWindow at the center of the screen
                popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

            }
        });

    }
}