package com.example.maxz.myapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void getTimeServer(){


        Calendar calNow = Calendar.getInstance();

        Calendar calSet = (Calendar) calNow.clone();

        calSet.set(Calendar.SECOND, 30);

        calSet.set(Calendar.MILLISECOND, 0);



        if(calSet.compareTo(calNow) <= 0){

//Today Set time passed, count to tomorrow

            calSet.add(Calendar.DATE, 1);

        }

        String indy = calSet.getTime().toString();



        textAlarmPrompt.setText(

                "\n\n***\n"

                + "Set Alarm @ " + calSet.getTime() + "\n"

                + "***\n");



        Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);

        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC_WAKEUP, calSet.getTimeInMillis(), pendingIntent);



    }
}
