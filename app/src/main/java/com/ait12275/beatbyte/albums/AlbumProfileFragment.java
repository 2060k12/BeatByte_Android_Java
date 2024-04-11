package com.ait12275.beatbyte.albums;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ait12275.beatbyte.R;
import com.ait12275.beatbyte.databinding.AlbumProfilefragmentBinding;
import com.squareup.picasso.Picasso;

public class AlbumProfileFragment extends Fragment {


    private AlbumProfilefragmentBinding binding;
    private Albums albums;
    ImageView img ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = AlbumProfilefragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        Bundle bundle = getArguments();
        if(bundle != null && bundle.containsKey("ALBUMS_PROFILES")){
            img = binding.albumArtImage;
            albums = (Albums) bundle.getSerializable("ALBUMS_PROFILES");
            String url = albums.albumArt;

            binding.albumNameText.setText(albums.getName());
            binding.aboutBodyText.setText(albums.getAbout());
            Toast.makeText(getContext(), albums.getName(), Toast.LENGTH_SHORT).show();

            Toast.makeText(getContext(), url, Toast.LENGTH_SHORT).show();
            Picasso.get().load(url).resize(360,230).into(img);
        }
    }
}