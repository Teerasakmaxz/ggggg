package com.example.maxz.time;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by maxz on 8/31/16 AD.
 */
public class DialogHandler extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            calendar = Calendar.getInstance();
        }
        int hour = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            hour = calendar.get(Calendar.HOUR_OF_DAY);
        }
        int minute = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            minute = calendar.get(Calendar.MINUTE);
        }
        TimePickerDialog dialog;
        TimeSettings timeSettings = new TimeSettings(getActivity());
        dialog = new TimePickerDialog(getActivity(), timeSettings, hour, minute, android.text.format.DateFormat.is24HourFormat(getActivity()));
        return dialog;

        //return super.onCreateDialog(savedInstanceState);
    }
}
