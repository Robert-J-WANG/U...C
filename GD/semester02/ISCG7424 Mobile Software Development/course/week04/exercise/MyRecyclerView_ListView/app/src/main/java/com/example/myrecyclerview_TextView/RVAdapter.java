package com.example.myrecyclerview_TextView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myrecyclerview_listview.R;


// step 3
// 创建适配器类继承自RecyclerView.Adapter，泛型传入RecyclerView.ViewHolder类
public class RVAdapter extends RecyclerView.Adapter <RVHolder>{
    String data[];
    // 初始化数据
    public RVAdapter(String[] data) {
        this.data = data;
    }

    // 重写此方法，用于常见ViewHolder类的实例对象，接受rv_item,返回一个ViewHolder对象
    @NonNull
    @Override
    public RVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 创建viewHolder,返回每一项的布局
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.rv_item,parent,false);
        return new RVHolder(view);
    }
    // 对没给item进行赋值,
    @Override
    public void onBindViewHolder(@NonNull RVHolder holder, int position) {
        // 将数据和控件绑定
        holder.tv.setText(data[position]);

    }

    // 返回总共有多少个item
    @Override
    public int getItemCount() {
        return data.length;
    }
}
