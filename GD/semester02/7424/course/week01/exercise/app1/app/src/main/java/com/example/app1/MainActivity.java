package com.example.app1;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app1.util.ToastUtil;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //申明控件
    Button mBtnLogin;
    // 申明用户名和秘密的变量
    EditText mEtUser, mEtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 找到控件
        mBtnLogin = findViewById(R.id.btn_1);

        // 找到用户名和密码
        mEtUser = findViewById(R.id.ed_1);
        mEtPassword = findViewById(R.id.ed_2);

//        // 实现直接跳转的方法1
//        mBtnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = null;
//                intent = new Intent(MainActivity.this, FunctionActivity.class);
//                startActivity(intent);
//            }
//        });

         // 实现直接跳转的方法2
        mBtnLogin.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        // 需要获取输入的用户名和密码
        String username=mEtUser.getText().toString();
        String password=mEtPassword.getText().toString();
        Intent intent;

        // 设置弹出的提示信息
        String ok="登录成功";
        String failed="用户名或密码错误";



        // 判断用户名和密码
        if(username.equals("a")&&password.equals("0")){
            // 输入正确，则跳转页面
            intent = new Intent(MainActivity.this, SlideActivity.class);
            startActivity(intent);

            // 输入正确，则跳转页面并且弹出提示信息，利用Toast类
            // 1. toast普通版
//            Toast.makeText(getApplicationContext(),ok,Toast.LENGTH_SHORT).show();

            // 3. 使用自己封装的类ToastUtil里面的方法showMsg
            ToastUtil.showMsg(MainActivity.this, ok);
        }
        else {
            // 输入错误，不跳转
//            // 2. toast居中版
//           Toast toastCenter=Toast.makeText(getApplicationContext(),failed,Toast.LENGTH_SHORT);
//           toastCenter.setGravity(Gravity.CENTER,0,0);
//           toastCenter.show();
            // 3. 使用自己封装的类ToastUtil里面的方法showMsg
            ToastUtil.showMsg(MainActivity.this,failed);
        }

    }
}