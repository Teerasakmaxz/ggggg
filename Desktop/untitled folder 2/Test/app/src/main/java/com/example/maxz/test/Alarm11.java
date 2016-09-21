package com.example.maxz.test;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by maxz on 9/15/2016 AD.
 */
public class Alarm11 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent i = new Intent(context, Main2Activity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
//        MainActivity instance = MainActivity.instance();
//        instance.setAlarmText("ปลุกแล้ววว");

    }
}
