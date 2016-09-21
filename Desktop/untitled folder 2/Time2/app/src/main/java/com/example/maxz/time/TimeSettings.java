package com.example.maxz.time;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by maxz on 8/31/16 AD.
 */
public class TimeSettings implements TimePickerDialog.OnTimeSetListener{

    Context context;

    public TimeSettings(Context context) {
        this.context = context;
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        Toast.makeText(context,"เลือกเวลา"+hourOfDay+"น."+minute+"นาที",Toast.LENGTH_LONG).show();

    }
}
