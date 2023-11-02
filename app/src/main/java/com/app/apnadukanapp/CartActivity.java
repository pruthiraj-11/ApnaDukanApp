package com.app.apnadukanapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.apnadukanapp.Adapters.CartAdapter;
import com.app.apnadukanapp.DbHelper.CartManagement;
import com.app.apnadukanapp.databinding.ActivityCartBinding;

public class CartActivity extends AppCompatActivity {
    ActivityCartBinding binding;
    RecyclerView.Adapter adapterCart;
    CartManagement cartManagement;
    double tax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cartManagement=new CartManagement(this);
        binding.cartBackButton.setOnClickListener(view -> finish());
        calculateCart();
        initRecyclerView();
    }

    private void initRecyclerView() {
        if (cartManagement.getListCart().isEmpty()){
            binding.emptyCartIndicator.setVisibility(View.VISIBLE);
            binding.cartScrollView.setVisibility(View.GONE);
        } else {
            binding.emptyCartIndicator.setVisibility(View.GONE);
            binding.cartScrollView.setVisibility(View.VISIBLE);
        }

        binding.cartView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        adapterCart=new CartAdapter(cartManagement.getListCart(), this, () -> calculateCart());
        binding.cartView.setAdapter(adapterCart);
    }

    private void calculateCart() {
        double percentTax=0.02;
        double delivery=10;
        tax=Math.round(cartManagement.getTotalFee()*percentTax*100.0)/100.0;

        double total=Math.round((cartManagement.getTotalFee()+tax+delivery)*100)/100;
        double itemTotal=cartManagement.getTotalFee()*100/100;
        binding.cartItemSubtotal.setText("$"+itemTotal);
        binding.cartItemTotalTax.setText("$"+tax);
        binding.cartItemDeliveryPrice.setText("$"+delivery);
        binding.cartItemTotalCost.setText(""+total);
    }
}