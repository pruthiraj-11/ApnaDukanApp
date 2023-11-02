package com.app.apnadukanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.app.apnadukanapp.DbHelper.CartManagement;
import com.app.apnadukanapp.Models.PopularModel;
import com.app.apnadukanapp.databinding.ActivityDetailBinding;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    private PopularModel popularModel;
    private int orderNumber=1;
    private CartManagement cartManagement;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cartManagement=new CartManagement(this);
        getBundle();
    }

    private void getBundle() {
        popularModel= (PopularModel) getIntent().getSerializableExtra("object");
        int drawableResourceId=this.getResources().getIdentifier(popularModel.getPicURL(),"drawable",this.getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(binding.detailPicImage);

        binding.detailtitle.setText(popularModel.getTitle());
        binding.detailPrice.setText("$ "+popularModel.getPrice());
        binding.itemdescriptiontxt.setText(popularModel.getDescription());
        binding.numberreviewdetail.setText(popularModel.getReview()+"");
        binding.scoredetailTxt.setText(popularModel.getScore()+"");

        binding.buybtn.setOnClickListener(view -> {
            popularModel.setNumberInCart(orderNumber);
            cartManagement.insertFoodItem(popularModel);
        });
        binding.backbtn.setOnClickListener(view -> finish());
    }
}