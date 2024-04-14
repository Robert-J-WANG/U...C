package com.example.firebasedemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.firebasedemo1.model.Controller;
import com.example.firebasedemo1.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    Controller controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Write a message to the database
        //FirebaseDatabase database = FirebaseDatabase.getInstance("https://fir-demo1-91d47-default-rtdb.firebaseio.com/");
        // DatabaseReference myRef = database.getReference("message");

        // myRef.setValue("Hello again");
        controller = new Controller();
    }

    public void addUser(View view) {
        User newUser = controller.createUser("John",
                "Morris","john@cs.nz");
        if(newUser == null){
            Toast.makeText(this, "Creating user failed",
                    Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this, "Creating user successful",
                    Toast.LENGTH_LONG).show();
    }

    public void updateUser(View view) {

        boolean success= controller.updateUser("-NS43Ixu1bRIOL5RfSfi","kate","petty","kp@gmial.com");

        if(!success){
            Toast.makeText(this, "Creating user failed",
                    Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this, "Creating user successful",
                    Toast.LENGTH_LONG).show();

    }

    public void deleteUser(View view) {
        String id ="-NS43Ixu1bRIOL5RfSfi";
        boolean success = controller.deleteUser(id);
        if(success){
            Toast.makeText(this, "User deleted successful", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Unable to delete user", Toast.LENGTH_LONG).show();

        }

    }

}