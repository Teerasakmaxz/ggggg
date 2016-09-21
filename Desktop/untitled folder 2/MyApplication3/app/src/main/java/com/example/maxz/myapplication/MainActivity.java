package com.example.maxz.myapplication;


import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

  TextView editTimeOpen, editTimeClose;
    Button buttonOpen, buttonClose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final Calendar calendar = Calendar.getInstance(Locale.getDefault());

        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute1 = calendar.get(Calendar.MINUTE);

        editTimeOpen = (TextView) findViewById(R.id.textView3);
        editTimeClose = (TextView) findViewById(R.id.textView4);
        buttonOpen = (Button) findViewById(R.id.button);
        buttonClose = (Button) findViewById(R.id.button2);





        buttonOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        //settxet ให้เปลี่ยนไปตามเวลาที่เราตั้งเปิด

                        if (minute < 10) {
                            editTimeOpen.setText(" 0" + hourOfDay + ":0" + minute);
                        } else if (hourOfDay < 10) {
                            editTimeOpen.setText(" 0" + hourOfDay + ":" + minute);
                        } else {
                            editTimeOpen.setText(" " + hourOfDay + ":" + minute);
                        }

                    }//method On TimeSet
                }, hour, minute1, true);
                timePickerDialog.show();
            }//Last method OnClick
        });//Last setOnClick

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog1 = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute11) {


                        //settxet ให้เปลี่ยนไปตามเวลาที่เราตั้งปิด
                        if (minute11 < 10) {
                            editTimeClose.setText(" 0" + hourOfDay + ":0" + minute11);

                        } else if (hourOfDay < 10) {
                            editTimeClose.setText(" 0" + hourOfDay + ":" + minute11);
                        } else {
                            editTimeClose.setText(" " + hourOfDay + ":" + minute11);
                        }

                    }//method On TimeSet
                }, hour, minute1, true);
                timePickerDialog1.show();

            }//Last method OnClick
        });//Last setOnClick


    }//main method

    public void myDialog(Context context, String strtitle, String strmessage) {

        AlertDialog.Builder builder =new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setTitle(strtitle);
        builder.setMessage(strmessage);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Intent intent = new Intent(MainActivity.this, IOIO.class);
                startActivity(intent);

                dialogInterface.dismiss();

            }
        });
        builder.show();

    }//mydialog

    public void Save(View view ) {

        myDialog(MainActivity.this,"บันทึก","บันทึกแล้วครับ");






    }

}//main class
