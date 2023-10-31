package com.app.apnadukanapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app.apnadukanapp.Adapters.PopularAdapter;
import com.app.apnadukanapp.Models.PopularModel;
import com.app.apnadukanapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private RecyclerView.Adapter adapterPopular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initRecyclerView();
    }

    private void initRecyclerView(){
        ArrayList<PopularModel> list=new ArrayList<>();
        list.add(new PopularModel("T-shirt black","Immerse yourself in a world of vibrant visuals and immersive sound with the VisionX Pro LED TV. Its cutting-edge LED technology brings every scene to life with striking clarity and rich colors. With seamless integration and a sleek, modern design, the VisionX Pro is not just a TV, but a centerpiece for your entertainment space. With its sleek, modern design, the VisionX Pro is not just a TV, but a centerpiece for your entertainment space. The ultra-slim bezel and premium finish blend seamlessly with any decor","item_1",15,4,50,500));
        list.add(new PopularModel("Smart Watch","Immerse yourself in a world of vibrant visuals and immersive sound with the VisionX Pro LED TV. Its cutting-edge LED technology brings every scene to life with striking clarity and rich colors. With seamless integration and a sleek, modern design, the VisionX Pro is not just a TV, but a centerpiece for your entertainment space. With its sleek, modern design, the VisionX Pro is not just a TV, but a centerpiece for your entertainment space. The ultra-slim bezel and premium finish blend seamlessly with any decor","item_2",157,4,5,535));
        list.add(new PopularModel("IPhone 14","Immerse yourself in a world of vibrant visuals and immersive sound with the VisionX Pro LED TV. Its cutting-edge LED technology brings every scene to life with striking clarity and rich colors. With seamless integration and a sleek, modern design, the VisionX Pro is not just a TV, but a centerpiece for your entertainment space. With its sleek, modern design, the VisionX Pro is not just a TV, but a centerpiece for your entertainment space. The ultra-slim bezel and premium finish blend seamlessly with any decor","item_3",110,9,5,90000));
        list.add(new PopularModel("VisionX Pro LED TV","Immerse yourself in a world of vibrant visuals and immersive sound with the VisionX Pro LED TV. Its cutting-edge LED technology brings every scene to life with striking clarity and rich colors. With seamless integration and a sleek, modern design, the VisionX Pro is not just a TV, but a centerpiece for your entertainment space. With its sleek, modern design, the VisionX Pro is not just a TV, but a centerpiece for your entertainment space. The ultra-slim bezel and premium finish blend seamlessly with any decor","item_4",12,4,6,74000));

        binding.popularview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterPopular=new PopularAdapter(list);
        binding.popularview.setAdapter(adapterPopular);
    }
}