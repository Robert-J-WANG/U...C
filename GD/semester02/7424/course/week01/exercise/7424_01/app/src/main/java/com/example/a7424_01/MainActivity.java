package com.example.a7424_01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txt1, txt2;
    TextView tvOp, tvRes;
    Button btnAdd, btnSub, btnMul, btnDiv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        tvOp = findViewById(R.id.tv_op);
        tvRes = findViewById(R.id.tv_eq);
        btnSub = findViewById(R.id.btn_sub);
        btnMul = findViewById(R.id.btn_mul);
//        btnAdd = findViewById(R.id.btn_add);
        btnDiv = findViewById(R.id.btn_div);
//        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }


    // 添加事件方式1，新建事件方法，在xml文件中绑定该事件：android:onClick="addNumbers"
    public void addNumbers(View view) {
        double n1, n2, r;
        n1 = Double.parseDouble(txt1.getText().toString());
        n2 = Double.parseDouble(txt2.getText().toString());
        r = n1 + n2;
        tvRes.setText("= " + r);
        Toast.makeText(this,
                "Button clicked",
                Toast.LENGTH_LONG).show();
    }

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
//            case R.id.btn_add: {
//                r = n1 + n2;
//                tvOp.setText("+");
//                tvRes.setText("= " + r);
//                break;
//            }
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
        }
    }

    public void playMusic(View view) {
        Toast.makeText(this,
                "image clicked",
                Toast.LENGTH_LONG).show();
        MediaPlayer mp = MediaPlayer.create(this, R.raw.yuanhang);
        mp.start();
    }

    public void changeImage(View view) {
        Toast.makeText(this,
                "image clicked",
                Toast.LENGTH_LONG).show();

    }
}