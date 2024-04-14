package com.example.exerfirebase01.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exerfirebase01.Model.Fruit;
import com.example.exerfirebase01.R;

import java.util.List;

public class FruitsRecyclerViewAdapter extends RecyclerView.Adapter<FruitsViewHolder> {
    private List<Fruit> fruits;

    public FruitsRecyclerViewAdapter(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    @NonNull
    public FruitsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FruitsViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fruit_layout, parent,
                                false)
        );
    }

    @Override
    public void onBindViewHolder(FruitsViewHolder holder, int position) {
        Fruit fruit = fruits.get(position);
        holder.nameTV.setText(fruit.getName());
        holder.colorTV.setText("Color:"+fruit.getColor());
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }
    public void setData(List<Fruit> fruits){ this.fruits =
            fruits; notifyDataSetChanged();
    }
}
