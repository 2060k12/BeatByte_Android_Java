package com.ait12275.beatbyte.homepage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.ait12275.beatbyte.artists.Artists;
import com.ait12275.beatbyte.databinding.RecyclerArtistViewBinding;

import java.util.List;

public class ArtistRecyclerViewAdapter extends ListAdapter<Artists, ArtistViewHolder> {

    private RecyclerArtistViewBinding binding;

    public ArtistRecyclerViewAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Artists> DIFF_CALLBACK = new DiffUtil.ItemCallback<Artists>() {
        @Override
        public boolean areItemsTheSame(@NonNull Artists oldItem, @NonNull Artists newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Artists oldItem, @NonNull Artists newItem) {
            return oldItem.getName() .equals(newItem.getName())&&
                    oldItem.getAbout().equals(newItem.getAbout());
        }
    };



    @NonNull
    @Override
    public ArtistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = RecyclerArtistViewBinding.inflate(inflater,parent,false);

        ArtistViewHolder artistViewHolder = new ArtistViewHolder(binding);
        return artistViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistViewHolder holder, int position) {
        // get Artist from the list based on the position
        Artists artists = getArtist(position);
        holder.updateArtist(artists);
    }

    public Artists getArtist(int position){
        return getItem(position);
    }

}
