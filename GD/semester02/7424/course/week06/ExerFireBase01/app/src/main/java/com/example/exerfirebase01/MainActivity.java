package com.example.exerfirebase01;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.exerfirebase01.Model.Fruit;
import com.example.exerfirebase01.Model.FruitController;
import com.example.exerfirebase01.RecyclerView.FruitsRecyclerViewAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText fruitET, colorET;
    Button btnAdd;
    RecyclerView fruitsRV;
    FruitsRecyclerViewAdapter adapter;
    ArrayList<Fruit> fruitList;
    String name;
    String color;

    FruitController fruitController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fruitET=findViewById(R.id.name);
        colorET=findViewById(R.id.color);

        /**
         FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference("message");
        myRef.setValue("hello hello");
        DatabaseReference myRef2=database.getReference("fruit");
        myRef2.setValue("apple");
         **/

        fruitController =new FruitController();
        btnAdd=findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                name=fruitET.getText().toString();
                color=colorET.getText().toString();
                fruitController.createFruit(name,color);
            }
        });


    }
}