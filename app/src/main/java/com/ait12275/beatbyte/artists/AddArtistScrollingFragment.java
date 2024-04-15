package com.ait12275.beatbyte.artists;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.ait12275.beatbyte.R;
import com.ait12275.beatbyte.databinding.AddArtistScrollingFragmentBinding;
import com.ait12275.beatbyte.homepage.HomepageViewModel;
import com.squareup.picasso.Picasso;

public class AddArtistScrollingFragment extends Fragment {


    AddArtistScrollingFragmentBinding binding;
    HomepageViewModel homepageViewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = AddArtistScrollingFragmentBinding.inflate(inflater, container, false);
        return  binding.getRoot();
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homepageViewModel = new ViewModelProvider(this).get(HomepageViewModel.class);


        binding.loadImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.get().load(binding.artistImageEditText.getText().toString()).resize(200,200).into(binding.artistImgImageView);
            }
        });
        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String artistName = binding.artistNameEditText.getText().toString();
                String about = binding.aboutEditText.getText().toString();
                String origin = binding.originEditText.getText().toString();
                String genres =binding.genresEditText.getText().toString();
                String labels = binding.labelsEditText.getText().toString();
                String members = binding.membersEditText.getText().toString();
                String website = binding.websiteEditText.getText().toString();
                String albums = binding.albumsEditText.getText().toString();
                String upComingEvents = binding.upcommingEventsEditText.getText().toString();
                String artistImg =binding.artistImageEditText.getText().toString();

                if(artistName != null){
                    homepageViewModel.insertArtist(new Artists(artistName,about,origin,genres,labels,members,website,upComingEvents,artistImg));
                    NavController navController = Navigation.findNavController(view);
                    navController.navigate(R.id.action_addAlbumsScrollingFragment_to_homepageFragment);

                }


            }
        });






    }
}