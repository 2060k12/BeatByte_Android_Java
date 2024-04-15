package com.ait12275.beatbyte.reviews;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.ait12275.beatbyte.databinding.RecyclerRatingReviewViewBinding;
import com.ait12275.beatbyte.databinding.RecyclerReviewViewBinding;

public class RatingRecyclerViewAdapter extends ListAdapter<Reviews, RatingsViewHolder> {
    public RatingRecyclerViewAdapter() {
        super(DIFF_CALLBACK);

    }

    private RecyclerRatingReviewViewBinding binding;

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
    public RatingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = RecyclerRatingReviewViewBinding.inflate(inflater,parent,false);
        RatingsViewHolder ratingsViewHolder = new RatingsViewHolder(binding);
        return ratingsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RatingsViewHolder holder, int position) {

        Reviews reviews = getReviewsAt(position);
        holder.updateReviewsAlbums(reviews);
    }


    public Reviews getReviewsAt(int position){
        return getItem(position);
    }
}
