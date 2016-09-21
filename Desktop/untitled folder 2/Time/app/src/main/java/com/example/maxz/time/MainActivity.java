package com.example.maxz.time;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    CountDownTimer cdt;
    TextView tvTimer;
    ToggleButton btnCount;
//    ProgressBar pbTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTimer = (TextView)findViewById(R.id.tvTimer);

//        pbTimer = (ProgressBar)findViewById(R.id.pbTimer);
//        pbTimer.setVisibility(View.INVISIBLE);
        btnCount = (ToggleButton)findViewById(R.id.btnCount);
        btnCount.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                if(isChecked) {
//                    pbTimer.setVisibility(View.VISIBLE);

                    cdt = new CountDownTimer(60000, 50) {
                        public void onTick(long millisUntilFinished) {
                            String strTime = String.format("%.1f"
                                    , (double)millisUntilFinished / 1000);
                            tvTimer.setText(String.valueOf(strTime));
                        }

                        public void onFinish() {
                            tvTimer.setText("0");
                            btnCount.setChecked(false);
//                            pbTimer.setVisibility(View.INVISIBLE);
                        }
                    }.start();
                } else {
                    cdt.cancel();
                    tvTimer.setText("0");
//                    pbTimer.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
