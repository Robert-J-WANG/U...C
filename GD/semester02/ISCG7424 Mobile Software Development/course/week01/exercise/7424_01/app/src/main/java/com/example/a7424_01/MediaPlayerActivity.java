package com.example.a7424_01;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MediaPlayerActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        img=findViewById(R.id.img);
        // 给图片添加监听事件
        img.setOnClickListener(this);
    }


    public void onClick(View view) {
        Toast.makeText(this,
                "image clicked",
                Toast.LENGTH_LONG).show();
        MediaPlayer mp = MediaPlayer.create(this, R.raw.bellbirdshort);
        mp.start();
    }
}