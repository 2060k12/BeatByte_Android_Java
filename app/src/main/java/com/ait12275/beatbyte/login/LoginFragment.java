package com.ait12275.beatbyte.login;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ait12275.beatbyte.R;
import com.ait12275.beatbyte.databinding.LoginFragmentBinding;
import com.ait12275.beatbyte.users.Users;

import java.util.List;

public class LoginFragment extends Fragment {

    private LoginFragmentBinding binding;
    private LoginViewModel mViewModel;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = LoginFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);


        final Observer<List<Users>> allUsersObserver = new Observer<List<Users>>() {
            @Override
            public void onChanged(List<Users> users) {
                Toast.makeText(getContext(), "New data inserted", Toast.LENGTH_SHORT).show();

            }
        };


        mViewModel.getAllUsers().observe(getViewLifecycleOwner(), allUsersObserver);


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    mViewModel.insert(new Users("pranish", "12345", "iampranish@outlook.com"));

            }
        });
    }

}