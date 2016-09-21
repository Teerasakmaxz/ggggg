package com.example.maxz.testee;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //ประกาศตัวแปร
    private ListView TeafficListView;
    private Button HOLDButton;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindWidgget();

        btncon();

        LisrViewController();




    }//oncreate

    private void LisrViewController() {

        final int[] intIcon = {R.drawable.traffic_01, R.drawable.traffic_02
                , R.drawable.traffic_03, R.drawable.traffic_04, R.drawable.traffic_05
                , R.drawable.traffic_06, R.drawable.traffic_07, R.drawable.traffic_08
                , R.drawable.traffic_09, R.drawable.traffic_10, R.drawable.traffic_11
                , R.drawable.traffic_12, R.drawable.traffic_13, R.drawable.traffic_14
                , R.drawable.traffic_15, R.drawable.traffic_16, R.drawable.traffic_17
                , R.drawable.traffic_18, R.drawable.traffic_19, R.drawable.traffic_20};

        final String[] TiteStrings = new String[20];

        TiteStrings[0] = "หัวข้อที่ 1";
        TiteStrings[1] = "หัวข้อที่ 2";
        TiteStrings[2] = "หัวข้อที่ 3";
        TiteStrings[3] = "หัวข้อที่ 4";
        TiteStrings[4] = "หัวข้อที่ 5";
        TiteStrings[5] = "หัวข้อที่ 6";
        TiteStrings[6] = "หัวข้อที่ 7";
        TiteStrings[7] = "หัวข้อที่ 8";
        TiteStrings[8] = "หัวข้อที่ 9";
        TiteStrings[9] = "หัวข้อที่ 10";
        TiteStrings[10] = "หัวข้อที่ 11";
        TiteStrings[11] = "หัวข้อที่ 12";
        TiteStrings[12] = "หัวข้อที่ 13";
        TiteStrings[13] = "หัวข้อที่ 14";
        TiteStrings[14] = "หัวข้อที่ 15";
        TiteStrings[15] = "หัวข้อที่ 16";
        TiteStrings[16] = "หัวข้อที่ 17";
        TiteStrings[17] = "หัวข้อที่ 18";
        TiteStrings[18] = "หัวข้อที่ 19";
        TiteStrings[19] = "หัวข้อที่ 20";

        final String[] strDetail = getResources().getStringArray(R.array.detail_shot);

        //call AD
        MyAD myAD = new MyAD(MainActivity.this, TiteStrings, strDetail, intIcon);
        TeafficListView.setAdapter(myAD);


        TeafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Detail.class);

                intent.putExtra("Titple", strDetail[position]);
                intent.putExtra("Image", intIcon[position]);
                intent.putExtra("Index", position);


                startActivity(intent);
            }
        });

    }//LisrViewController

    private void btncon() {

        HOLDButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("https://youtu.be/YQHsXMglC9A"));
                startActivity(intent1);

            }
        });


    }//btncon

    private void bindWidgget() {
        TeafficListView = (ListView) findViewById(R.id.listView);
        HOLDButton = (Button) findViewById(R.id.button);

    }

}//main class
