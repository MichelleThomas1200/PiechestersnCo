package com.example.piechestersnco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.Display;

import com.example.piechestersnco.Adapters.CartAdapter;
import com.example.piechestersnco.Models.CartModel;
import com.example.piechestersnco.databinding.ActivityCartBinding;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ActivityCartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DBHelper helper=new DBHelper(this);
        ArrayList<CartModel> list= helper.getOrders(); //calls getOrders() from DBHelper

        CartAdapter adapter=new CartAdapter(list, this);
        binding.cartRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.cartRecyclerView.setLayoutManager(layoutManager);
    }
}