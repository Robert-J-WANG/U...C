package com.example.myapp2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapp2.util.ToastUtil;

public class Exercise2_Activity extends AppCompatActivity implements View.OnClickListener {
    //申明控件
    Button mBtnLogin, mBtnRegister, mBtnCancel;
    // 申明用户名和秘密的变量
    EditText mEtUser, mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);
        // 找到控件
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnRegister = findViewById(R.id.btn_reg);
        mBtnCancel = findViewById(R.id.btn_cnl);

        // 找到用户名和密码
        mEtUser = findViewById(R.id.ed_1);
        mEtPassword = findViewById(R.id.ed_2);

        // 给按钮绑定click事件
        mBtnLogin.setOnClickListener(this);
        mBtnRegister.setOnClickListener(this);
        mBtnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // 点击按钮实现页面跳转
        // 需要获取输入的用户名和密码
        String username = mEtUser.getText().toString();
        String password = mEtPassword.getText().toString();
        Intent intent = null;

        // 设置弹出的提示信息
        String ok = "登录成功";
        String failed = "用户名或密码错误";


        switch (view.getId()) {
            case R.id.btn_login:

                // 判断用户名和密码
                if (username.equals("a") && password.equals("1")) {
                    // 输入正确，则跳转页面
                    intent = new Intent(Exercise2_Activity.this, Exercise2_Login_Activity.class);

                    // 输入正确，则跳转页面并且弹出提示信息，利用Toast类
                    // 1. toast普通版
//            Toast.makeText(getApplicationContext(),ok,Toast.LENGTH_SHORT).show();

                    // 3. 使用自己封装的类ToastUtil里面的方法showMsg
                    ToastUtil.showMsg(Exercise2_Activity.this, ok);
                } else {
                    // 输入错误，不跳转
                    intent = new Intent(Exercise2_Activity.this, Exercise2_Activity.class);

                    // 3. 使用自己封装的类ToastUtil里面的方法showMsg
                    ToastUtil.showMsg(Exercise2_Activity.this, failed);
                }
                break;
            case R.id.btn_reg:
                intent = new Intent(Exercise2_Activity.this, Exercise2_Register_Activity.class);
                break;
            case R.id.btn_cnl:
                intent = new Intent(Exercise2_Activity.this, MainActivity.class);
                break;
        }
        startActivity(intent);


    }
}