package com.example.maxz.sqlist;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class form extends AppCompatActivity {

    private TextView txtShowtime;
    private EditText extweight;
    private String strShowtime,strweight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        bindwetget();

        getTime();

    }
    // กดปุ่ม  SAVE แล้วจะเช็คว่ามีค่าว่างไหม ถ้ามี โชว์ method showss ถ้าไม่มี โชว์ method showLog  และ confrimDB
    public void ClickSAVE (View view) {
        strweight = extweight.getText().toString().trim();
        if (strweight.equals("")) {
            showss();

        } else {
            showLog();

            comfrimDB();
        }

    }
//ไดร์อะลอกสำหรับโชว์เพื่อคอนเฟมก่อนจะเข้า SQLite
    private void comfrimDB() {

        final AlertDialog.Builder objAlert =new AlertDialog.Builder(this);
        objAlert.setTitle("Are you Sure ?");
        objAlert.setMessage("Date ="+strShowtime+"\n" +"weight="+strweight +"kg");
        objAlert.setCancelable(false);
        objAlert.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
       objAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {


               UpdateSQLite();
           }
       });
        objAlert.show();

    }
//ทำการโยนค่าไปเข้า SQList
    private void UpdateSQLite() {
         WeightTABLE objweight =new WeightTABLE(this);
                                                        //แปลงจาก String ให้เป็น Double
        long inDATA =objweight.addNewvalue(strShowtime,Double.parseDouble(strweight));
        extweight.setText("");
        //ส่งเข้าไปใน SQList เส็จแล้วจะขึ้น toast "สำเร็จแล้ว"
        Toast.makeText(form.this,"สำเร็จแล้ว",Toast.LENGTH_SHORT).show();
    }
// โชว์ไดร์อะลอก ที่มีน้ำหนักที่เรากรอก
    private void showLog() {
        Log.d("weight", "time = " +strShowtime);
        Log.d("weight", "weight = " +strweight);
    }
//ทำไดร์อะลอกแสดงค่าว่างมีปุ่ม OK ให้กดได้เพื่อกรอกใหม่
    private void showss() {
        AlertDialog.Builder odjAlert =new AlertDialog.Builder(this);
//        odjAlert.setIcon(R.drawable.adm);
        odjAlert.setMessage("Emty");
        odjAlert.setCancelable(false);
        odjAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        odjAlert.show();

    }//showss



//โชว์วันเดือนปี เดือนใช้ MM
    private void getTime() {
        SimpleDateFormat odjDateFromat =new SimpleDateFormat("dd/MM/yy");
        Date odjDate =new Date();
        strShowtime=odjDateFromat.format(odjDate);
        txtShowtime.setText(strShowtime);
    }

    private void bindwetget() {
        txtShowtime =(TextView) findViewById(R.id.txtShowtime);
        extweight =(EditText)findViewById(R.id.editText);
    }
}
