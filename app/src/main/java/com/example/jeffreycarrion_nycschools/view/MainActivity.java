package com.example.jeffreycarrion_nycschools.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.jeffreycarrion_nycschools.R;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements Listener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDisplayFragment();
    }

    private void showDisplayFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new SchoolDisplay())
                .commit();
    }

    @Override
    public void openDetails(String dbn, String name, String loc, String email, String phone) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new SchoolDetails().getInstance(dbn, name, loc, email, phone))
                .addToBackStack(null)
                .commit();
    }

}