package com.ait12275.beatbyte.users;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Insert;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ait12275.beatbyte.R;
import com.ait12275.beatbyte.UsersRepository;
import com.ait12275.beatbyte.databinding.UsersFragmentBinding;

import java.util.List;

public class UsersFragment extends Fragment {

    private UsersViewModel mViewModel;
    private UsersFragmentBinding binding;

    public static UsersFragment newInstance() {
        return new UsersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = UsersFragmentBinding.inflate(inflater, container,false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(UsersViewModel.class);


        final Observer<List<Users>> allUsersObserver = new Observer<List<Users>>() {
            @Override
            public void onChanged(List<Users> users) {
                Toast.makeText(getContext(), "New data inserted", Toast.LENGTH_SHORT).show();

                }
        };


        mViewModel.getAllusers().observe(getViewLifecycleOwner(), allUsersObserver);


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.insert(new Users("pranish", "12345", "iampranish@outlook.com"));
            }
        });
    }
}