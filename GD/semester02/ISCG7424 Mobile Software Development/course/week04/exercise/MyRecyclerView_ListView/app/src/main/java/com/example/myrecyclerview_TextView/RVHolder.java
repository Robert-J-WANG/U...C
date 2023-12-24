package com.example.myrecyclerview_TextView;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrecyclerview_listview.R;


// step 4: 创建内部类即RecyclerView.ViewHolder类的子类，用于绑定TextView控件
public class RVHolder extends RecyclerView.ViewHolder {
    TextView tv;
    public RVHolder(@NonNull View itemView) {
        super(itemView);
        tv=itemView.findViewById(R.id.item_name);
    }
}
