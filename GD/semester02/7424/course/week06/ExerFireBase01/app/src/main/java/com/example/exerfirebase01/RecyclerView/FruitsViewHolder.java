package com.example.exerfirebase01.RecyclerView;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exerfirebase01.R;

public class FruitsViewHolder extends RecyclerView.ViewHolder
{
    TextView nameTV, colorTV;
    public FruitsViewHolder(View itemView) {
        super(itemView);
        nameTV = itemView.findViewById(R.id.nameTV);
        colorTV =
                itemView.findViewById(R.id.colorTV);
    }
}

