package com.example.myrecyclerview_TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myrecyclerview_listview.R;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // step 5:在Activity中获取RecyclerView控件然后进行设置LayoutManger以及Adapter即可
        recyclerView=findViewById(R.id.r_view);

        // 添加数据，初始化数据
        String []data = {"New Zealand","Australia","USA","China","India","Pakistan","UAE","UK","Canada","South Africa", "Japan","Fiji"};
        // 实例化适配器
        RVAdapter adapter = new RVAdapter(data);

        //设置LayoutManager
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));

        //设置适配器
        recyclerView.setAdapter(adapter);
    }
}