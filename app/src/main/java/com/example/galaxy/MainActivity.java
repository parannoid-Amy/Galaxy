package com.example.galaxy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button) findViewById(R.id.imageButton);
        btn4=(Button) findViewById(R.id.imageButton2);
        btn4=(Button) findViewById(R.id.imageButton3);
        btn4=(Button) findViewById(R.id.imageButton4);

        //为button1绑定事件
        btn1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //页面刷新
                return false;
            }
        });

        //为button2绑定事件


    }
}