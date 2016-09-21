package com.example.maxz.testee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    //ประกาศตัวแปร
    private TextView titeTextView, deailTextView;
    private ImageView trafficImageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Widget();

        ShowView();


    }//oncreate

    public void ClickBack(View view) {
        finish();
    }

    private void ShowView() {
        //รับค่าจาก Intent

        String strTitle = getIntent().getStringExtra("Title");
        int intImage = getIntent().getIntExtra("Image", R.drawable.traffic_01);
        int intIndex = getIntent().getIntExtra("Index", 0);

        titeTextView.setText(strTitle);

        trafficImageView.setImageResource(intImage);

        String[] detailStrings = getResources().getStringArray(R.array.detail_long);
        deailTextView.setText(detailStrings[intIndex]);


    }//ShowView

    private void Widget() {
        titeTextView = (TextView) findViewById(R.id.textView4);
        deailTextView = (TextView) findViewById(R.id.textView5);
        trafficImageView = (ImageView) findViewById(R.id.imageView2);
    }


}//main class
