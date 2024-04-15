package com.ait12275.beatbyte.reviews;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.ait12275.beatbyte.albums.Albums;
import com.ait12275.beatbyte.databinding.RecyclerReviewViewBinding;

public class ReviewsRecyclerViewAdapter extends ListAdapter<Reviews, ReviewsViewHolder>{


    public ReviewsRecyclerViewAdapter() {
        super(DIFF_CALLBACK);

    }

    private RecyclerReviewViewBinding binding;

    private static final DiffUtil.ItemCallback<Reviews> DIFF_CALLBACK = new DiffUtil.ItemCallback<Reviews>() {
        @Override
        public boolean areItemsTheSame(@NonNull Reviews oldItem, @NonNull Reviews newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Reviews oldItem, @NonNull Reviews newItem) {
            return (oldItem.getComment().equals(newItem.getComment()) && oldItem.getRating() == newItem.getRating());
        }
    };



    @NonNull
    @Override
    public ReviewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = RecyclerReviewViewBinding.inflate(inflater,parent,false);
        ReviewsViewHolder reviewsViewHolder = new ReviewsViewHolder(binding);
        return reviewsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewsViewHolder holder, int position) {

        Reviews reviews = getReviewsAt(position);
        holder.updateReviews(reviews);
    }


    public Reviews getReviewsAt(int position){
        return getItem(position);
    }

}
