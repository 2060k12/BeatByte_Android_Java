package com.ait12275.beatbyte.homepage;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ait12275.beatbyte.R;
import com.ait12275.beatbyte.artists.Artists;
import com.ait12275.beatbyte.databinding.RecyclerArtistViewBinding;
import com.squareup.picasso.Picasso;

public class ArtistViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    private RecyclerArtistViewBinding binding;


    public ArtistViewHolder(@NonNull RecyclerArtistViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void updateArtist(Artists artists){

        imageView = binding.artistImage;
        String url = artists.getArtistImg();
        binding.artistName.setText(artists.getName());
        if( url != null && !url.isEmpty() ) {
            Picasso.get().load(url).resize(200, 200).centerCrop().into(binding.artistImage);
        }
    }
}
