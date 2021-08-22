package com.example.piechestersnco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.piechestersnco.Adapters.MainAdapter;
import com.example.piechestersnco.Models.MainModel;
import com.example.piechestersnco.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list=new ArrayList<>();

        list.add(new MainModel(R.drawable.sugrpie, "Sugar Pie", "50", "Creamy, caramelized pie to sweeten your day"));
        list.add(new MainModel(R.drawable.chocpdngpie, "Choco Pudding Pie", "50", "Buttery, delicious, baked chocolate pudding dessert"));
        list.add(new MainModel(R.drawable.applepie, "Apple Pie", "55", "Pie filled with fresh and juicy apples, topped with a dash of cinnamon"));
        list.add(new MainModel(R.drawable.limecreampie, "Lime Cream Pie", "60", "Light, fluffy cream filled Pie with lemon zest"));
        list.add(new MainModel(R.drawable.bbpie, "BlueBerry Pie", "65", "Blueberry flavored cream pie"));
        list.add(new MainModel(R.drawable.vegpotpie, "Veggie Pot Pie", "75", "Savoury pie stuffed with mashed potatoes and other flavored veggies"));
        list.add(new MainModel(R.drawable.chknpie, "Shepherd's Pie", "80", "Savoury pie filled with mouth-watering chicken stuffing"));

        MainAdapter adapter= new MainAdapter(list, this);
        binding.recyclerView.setAdapter(adapter);//

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);//converts menu.xml and associates it with ManiActivity.java
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this, CartActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}