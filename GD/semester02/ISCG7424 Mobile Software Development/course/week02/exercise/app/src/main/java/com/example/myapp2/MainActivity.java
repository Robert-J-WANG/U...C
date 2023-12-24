package com.example.myapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_exes1,btn_exes2,btn_exes3,btn_exes4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_exes1 = findViewById(R.id.btn_exes1);
        btn_exes2 = findViewById(R.id.btn_exes2);
        btn_exes3 = findViewById(R.id.btn_exes3);
        btn_exes4 = findViewById(R.id.btn_exes4);

        btn_exes1.setOnClickListener(this);
        btn_exes2.setOnClickListener(this);
        btn_exes3.setOnClickListener(this);
        btn_exes4.setOnClickListener(this);

//        // 实现直接跳转的方法1
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = null;
//                intent = new Intent(MainActivity.this, Exercise1_Activity.class);
//                startActivity(intent);
//            }
//        });

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btn_exes1:
                intent = new Intent(MainActivity.this, Exercise1_Activity.class);
                break;
            case R.id.btn_exes2:
                intent = new Intent(MainActivity.this, Exercise2_Activity.class);
                break;
            case R.id.btn_exes3:
                intent = new Intent(MainActivity.this, Exercise3_Activity.class);
                break;
            case R.id.btn_exes4:
                intent = new Intent(MainActivity.this, Exercise4_Activity.class);
                break;
        }
        startActivity(intent);
    }


}