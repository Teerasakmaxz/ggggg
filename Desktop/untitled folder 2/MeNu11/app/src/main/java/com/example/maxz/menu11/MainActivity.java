package com.example.maxz.menu11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //ประกาศตัวแปร Button
    Button myButton,myButton2,myButton3, myButton4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //เชื่อมกับ ID ปุ่มหน้า MainActivity
        myButton = (Button) findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Intent1.class);
                startActivity(intent);
            }
        });//myButton
        myButton2 = (Button) findViewById(R.id.button2);
        myButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, Intent2.class);
                startActivity(intent1);
            }
        });//myButton2
        myButton3 = (Button) findViewById(R.id.button3);
        myButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, Intent3.class);
                startActivity(intent3);
            }
        });
        myButton4 = (Button) findViewById(R.id.button4);


    }//main method

    public void Intent4(View view) {

        Intent intent4 = new Intent(MainActivity.this, Intent4.class);
        startActivity(intent4);

    }//Intnet4

}// main class
