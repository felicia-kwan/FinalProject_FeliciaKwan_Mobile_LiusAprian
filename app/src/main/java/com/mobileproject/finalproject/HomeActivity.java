package com.mobileproject.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mobileproject.finalproject.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String nama = getIntent().getStringExtra("User name");
        setTitle(nama);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_layout, new HomeFragment())
                .commit();
    }
}