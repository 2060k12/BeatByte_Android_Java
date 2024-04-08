package com.ait12275.beatbyte.homepage;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ait12275.beatbyte.albums.Albums;
import com.ait12275.beatbyte.databinding.RecyclerItemViewBinding;
import com.squareup.picasso.Picasso;

public class AlbumsViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    private RecyclerItemViewBinding binding;
    public AlbumsViewHolder(@NonNull RecyclerItemViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void updateAlbum(Albums albums){
        imageView = binding.albumArt;
        String url = albums.getAlbumArt();
        binding.albumName.setText(albums.getName());
        Picasso.get().load(url).into(imageView);
    }

    public void bind(Albums albums, OnItemClickListener onItemClickListener){
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(albums, v);
            }
        });
    }


}
