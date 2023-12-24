package com.example.myapp2;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapp2.util.ToastUtil;

public class Exercise2_Register_Activity extends AppCompatActivity implements View.OnClickListener {

    //    //申明控件
    Button uBtnRegister, uBtnAddMore, uBtnCancel;
    // 申明用户名和秘密的变量
    EditText uEtFirstName, uEtLastName, uEtUserName, uEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2_register);

        // 获取用户信息
        uEtFirstName=findViewById(R.id.ed_firstname);
        uEtLastName=findViewById(R.id.ed_lastname);
        uEtUserName=findViewById(R.id.ed_username);
        uEtPassword=findViewById(R.id.ed_password);

        // 获取按钮控件
        uBtnRegister = findViewById(R.id.btn_register);
        uBtnAddMore = findViewById(R.id.btn_addMore);
        uBtnCancel = findViewById(R.id.btn_cancel);
//
//
//        // 按钮绑定注册事件
        uBtnRegister.setOnClickListener(this);
        uBtnAddMore.setOnClickListener(this);
        uBtnCancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        // 点击按钮实现页面跳转
        // 保存获取输入的用户名和密码
        String firstname = uEtFirstName.getText().toString();
        String lastname = uEtLastName.getText().toString();
        String username = uEtUserName.getText().toString();
        String password = uEtPassword.getText().toString();

        // 设置弹出的提示信息
        String ok = "Register Successfully";
        String failed = "Personal information can not be null, Please try it again";

        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_register:
                if (firstname.equals("")||lastname.equals("")||username.equals("")||password.equals("")) {

                    ToastUtil.showMsg(Exercise2_Register_Activity.this, failed);

                    intent = new Intent(Exercise2_Register_Activity.this, Exercise2_Register_Activity.class);

                } else {
                    ToastUtil.showMsg(Exercise2_Register_Activity.this, ok);


                    intent = new Intent(Exercise2_Register_Activity.this, Exercise2_Register_Success_Activity.class);

                    // 跨页面传递数据？？？？
                }
                break;

            case R.id.btn_addMore:
                intent = new Intent(Exercise2_Register_Activity.this, Exercise2_Register_Activity.class);
                break;

            case R.id.btn_cancel:
                intent = new Intent(Exercise2_Register_Activity.this, Exercise2_Activity.class);
                break;
        }
        startActivity(intent);

    }
}