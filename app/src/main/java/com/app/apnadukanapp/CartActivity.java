package com.app.apnadukanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.app.apnadukanapp.databinding.ActivityCartBinding;

public class CartActivity extends AppCompatActivity {
    ActivityCartBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}