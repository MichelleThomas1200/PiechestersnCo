package com.example.piechestersnco.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.piechestersnco.DetailActivity;
import com.example.piechestersnco.Models.MainModel;
import com.example.piechestersnco.R;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder>{

    ArrayList<MainModel> list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.menu_itemsample, parent, false);//inflating the view
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        final MainModel model= list.get(position);
        holder.foodimage.setImageResource(model.getImage());
        holder.mainName.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.description.setText(model.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("image", model.getImage());
                intent.putExtra("price", model.getPrice());
                intent.putExtra("desc", model.getDescription());
                intent.putExtra("name", model.getName());
                intent.putExtra("type", 1);//insertion
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size(); //i.e. no. of items in the list becomes the size of the recycler view
    }

    public class viewholder extends RecyclerView.ViewHolder {

        ImageView foodimage;
        TextView mainName, price, description;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            foodimage=itemView.findViewById(R.id.imageView);
            mainName=itemView.findViewById(R.id.name);
            price=itemView.findViewById(R.id.itemCost);
            description=itemView.findViewById(R.id.description);

        }
    }
}
