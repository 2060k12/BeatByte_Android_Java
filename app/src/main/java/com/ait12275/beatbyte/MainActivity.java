package com.ait12275.beatbyte;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//
//        if(savedInstanceState == null){
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, UsersFragment.newInstance()).commitNow();
//        }
    }
}