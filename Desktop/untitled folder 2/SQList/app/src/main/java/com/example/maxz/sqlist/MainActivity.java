package com.example.maxz.sqlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private WeightTABLE objWeighTABLE;
    private TextView textViewshowweight;
    private double douweight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewshowweight = (TextView) findViewById(R.id.textView4);

//        setCurrentWeight();

        connectBD();




    }//onCreate

    private void setCurrentWeight() {
         douweight = objWeighTABLE.currentwight();
        textViewshowweight.setText(Double.toString(douweight));
    }

    // เป็นการสลับหน้า ไปยัง form.java
    public void ClickUpdate(View view){
        Intent i =new Intent(MainActivity.this,form.class);
        startActivity(i);

    }
    private void connectBD() {

        objWeighTABLE = new WeightTABLE(this);


    }//conectDB
}//main class
