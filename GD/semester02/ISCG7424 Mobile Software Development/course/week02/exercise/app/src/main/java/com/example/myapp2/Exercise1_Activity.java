package com.example.myapp2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Exercise1_Activity extends AppCompatActivity implements View.OnClickListener {

    EditText txt1, txt2;
    TextView tvOp, tvRes;
    Button btnAdd, btnSub, btnMul, btnDiv, btnClear;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        tvOp = findViewById(R.id.tv_op);
        tvRes = findViewById(R.id.tv_eq);
        btnSub = findViewById(R.id.btn_sub);
        btnMul = findViewById(R.id.btn_mul);
        btnAdd = findViewById(R.id.btn_add);
        btnDiv = findViewById(R.id.btn_div);
        btnClear = findViewById(R.id.btn_clear);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

//
//    // 添加事件方式1，新建事件方法，在xml文件中绑定该事件：android:onClick="addNumbers"
//    public void addNumbers(View view) {
//        double n1, n2, r;
//        n1 = Double.parseDouble(txt1.getText().toString());
//        n2 = Double.parseDouble(txt2.getText().toString());
//        r = n1 + n2;
//        tvRes.setText("= " + r);
//        Toast.makeText(this,
//                "Button clicked",
//                Toast.LENGTH_LONG).show();
//    }

    // 添加事件方式2，新建事件方法，在主程序的onCreate方法里绑定事件 btnSub.setOnClickListener(this);并引入implements View.OnClickListener

    @Override
    public void onClick(View view) {
        Toast.makeText(this,
                "Sub Button clicked",
                Toast.LENGTH_LONG).show();

        double n1, n2, r;
        n1 = Double.parseDouble(txt1.getText().toString());
        n2 = Double.parseDouble(txt2.getText().toString());

        switch (view.getId()) {

            // 使用添加时间方式1， 绑定了事件
            case R.id.btn_add: {
                r = n1 + n2;
                tvOp.setText("+");
                tvRes.setText("= " + r);
                break;
            }
            case R.id.btn_sub: {
                r = n1 - n2;
                tvOp.setText("-");
                tvRes.setText("= " + r);
                break;
            }
            case R.id.btn_mul: {
                r = n1 * n2;
                tvOp.setText("*");
                tvRes.setText("= " + r);
                break;
            }
            case R.id.btn_div: {
                r = n1 / n2;
                tvOp.setText("/");
                tvRes.setText("= " + r);
                break;
            }
            case R.id.btn_clear: {
                if ((txt1.getHint().toString().equals("10")) || (txt1.getHint().toString().equals("10"))||tvRes.getText().toString().equals("=20")) {
                    Intent intent = null;
                    intent = new Intent(Exercise1_Activity.this, Exercise1_Activity.class);
                    startActivity(intent);
                } else {
                    txt1.setText("");
                    txt2.setText("");
                    tvOp.setText("+");
                    tvRes.setText("= " + 20);
                }
//
                break;
            }
        }
    }

    public void playMusic(View view) {
        Toast.makeText(this,
                "music is playing",
                Toast.LENGTH_LONG).show();
        MediaPlayer mp = MediaPlayer.create(this, R.raw.yuanhang);
        mp.start();
    }

    public void changeImage(View view) {
        Toast.makeText(this,
                "image clicked",
                Toast.LENGTH_LONG).show();

    }
    public void goHomePage(View view){
        Toast.makeText(this,
                "back to homepage",
                Toast.LENGTH_LONG).show();

        Intent intent = null;
        intent = new Intent(Exercise1_Activity.this, MainActivity.class);
        startActivity(intent);

    }

}