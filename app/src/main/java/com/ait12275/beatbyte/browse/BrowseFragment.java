package com.ait12275.beatbyte.browse;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import com.ait12275.beatbyte.R;
import com.ait12275.beatbyte.albums.Albums;
import com.ait12275.beatbyte.databinding.BrowseFragmentBinding;
import com.ait12275.beatbyte.homepage.AlbumsRecyclerViewAdapter;
import com.ait12275.beatbyte.homepage.HomepageViewModel;
import com.ait12275.beatbyte.homepage.OnItemClickListener;

import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BrowseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrowseFragment extends Fragment {


    BrowseFragmentBinding binding;

    private OnItemClickListener onItemClickListener;

    // Declaring view models , to work with database
    HomepageViewModel mViewModel;
    public BrowseFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = BrowseFragmentBinding.inflate(inflater, container, false);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new HomepageViewModel(new Application());

        binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Albums> searchAlbums = Collections.singletonList(mViewModel.searchAlbums(binding.searchTextBox.getText().toString()));


                //Layout manager for Albums
                binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                binding.recyclerView.setHasFixedSize(true);

                AlbumsRecyclerViewAdapter albumsAdapter = new AlbumsRecyclerViewAdapter();
                binding.recyclerView.setAdapter(albumsAdapter);
                albumsAdapter.submitList(searchAlbums);
            }
        });


    }
}