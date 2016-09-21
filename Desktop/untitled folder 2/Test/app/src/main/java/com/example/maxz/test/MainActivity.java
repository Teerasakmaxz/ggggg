package com.example.maxz.test;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
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


    Button myButton;
    TextView textView, textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute1 = calendar.get(Calendar.MINUTE);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);


        myButton = (Button) findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {


                        Calendar calendar1 = Calendar.getInstance(Locale.getDefault());
                        calendar1.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar1.set(Calendar.MINUTE, minute);
                        calendar1.set(Calendar.SECOND, 0);
                        calendar1.set(Calendar.MILLISECOND, 0);
                        textView.setText(hourOfDay + ":" + minute);

                        setAlarm(calendar1);
                    }


                }, hour, minute1, true);//TimePickerDialog
                timePickerDialog.show();
            }
        });//myButton
    }//main method

    private void setAlarm(Calendar alarm) {

        final int _id = (int) System.currentTimeMillis();
        Intent intent = new Intent(getBaseContext(), Alarm11.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), _id, intent,0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, alarm.getTimeInMillis(), pendingIntent);


    }

//    public void setAlarmText(String alarmText) {
//        Toast.makeText(MainActivity.this, alarmText, Toast.LENGTH_LONG).show();
//    }

//    public static MainActivity instance() {
//
//        return instance;
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        instance = this;
//    }
}//main class
