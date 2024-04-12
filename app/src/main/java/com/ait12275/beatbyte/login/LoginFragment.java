package com.ait12275.beatbyte.login;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ait12275.beatbyte.R;
import com.ait12275.beatbyte.albums.Albums;
import com.ait12275.beatbyte.databinding.LoginFragmentBinding;
import com.ait12275.beatbyte.users.Users;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class LoginFragment extends Fragment {

    private LoginFragmentBinding binding;
    private LoginViewModel mViewModel;
    private Users users;
    public static String loggedInUserEmail;



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
        // Access the bottom navigation view from the activity






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

//                    mViewModel.insert(new Users("pranish", "12345", "iampranish@outlook.com"));
                String email = binding.editTextTextEmailAddress.getText().toString();
                String password =binding.editTextTextPassword.getText().toString();

                if(mViewModel.checkLogin(email, password) != null){
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("USER_DETAILS", users);
                    NavController navController = Navigation.findNavController(v);
                    navController.navigate(R.id.action_loginFragment_to_homepageFragment2);
                    loggedInUserEmail = email;

                }

                else {
                    Toast.makeText(getContext(), "Wrong Email Or Password", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }


}