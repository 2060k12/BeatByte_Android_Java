package com.ait12275.beatbyte.homepage;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ait12275.beatbyte.R;
import com.ait12275.beatbyte.albums.Albums;
import com.ait12275.beatbyte.databinding.HomepageFragmentBinding;

import java.io.Serializable;
import java.util.List;

public class HomepageFragment extends Fragment implements OnItemClickListener{

    HomepageFragmentBinding binding;
    private HomepageViewModel mViewModel;

    public static HomepageFragment newInstance() {
        return new HomepageFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = HomepageFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomepageViewModel.class);

    binding.albumsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    binding.albumsRecyclerView.setHasFixedSize(true);

    AlbumsRecyclerViewAdapter adapter = new AlbumsRecyclerViewAdapter(this);
    binding.albumsRecyclerView.setAdapter(adapter);

    final Observer<List<Albums>> albumsObserver  = new Observer<List<Albums>>() {
        @Override
        public void onChanged(List<Albums> albums) {
            adapter.submitList(albums);
        }
    };

    mViewModel.getAllAlbums().observe(getViewLifecycleOwner(),albumsObserver);


    binding.addDataButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mViewModel.insert(new Albums(1,"Beatles","","","","","","","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJv6GuGnysJIrgtmGZsD_SN-Ns7e7PBoEqjdwEgtt46w&s"));
        }
    });
    }

    @Override
    public void onClick(Albums albums, View view) {
        Log.i("XYZ", albums.toString());
        Bundle bundle = new Bundle();
        bundle.putSerializable("ALBUMS_PROFILES", albums);

        NavController navController = Navigation.findNavController(view);
        navController.navigate(R.id.action_homepageFragment2_to_albumProfileFragment, bundle);

    }
}