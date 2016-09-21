package com.example.maxz.db;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splashscreen extends AppCompatActivity {
    private Handler objheander;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        objheander = new Handler();
        objheander.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent objheander = new Intent(Splashscreen.this, Start.class);
                startActivity(objheander);
                finish();


            }
        }, 3000);
    }
    }

