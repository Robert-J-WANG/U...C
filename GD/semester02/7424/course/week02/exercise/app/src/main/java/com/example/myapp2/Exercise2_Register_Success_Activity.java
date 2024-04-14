package com.example.myapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Exercise2_Register_Success_Activity extends AppCompatActivity {

    TextView pFirstName,pLastName,pUserName,pPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2_register_success);
        pFirstName=findViewById(R.id.p_firstname);
        pLastName=findViewById(R.id.p_lastname);
        pUserName=findViewById(R.id.p_username);
        pPassword=findViewById(R.id.p_password);

    }
}