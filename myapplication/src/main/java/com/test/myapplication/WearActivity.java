package com.test.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.wearable.activity.WearableActivity;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class WearActivity extends WearableActivity {

    private Chronometer chronometer;

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wear);
        chronometer = findViewById(R.id.timer_task);
        new CountDownTimer(5000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                onMenuActivity();
            }
        }.start();

        // Enables Always-on
//        setAmbientEnabled();
    }
    public void onMenuActivity(){
        Intent intent = new Intent(getApplicationContext(),MenuWearActivity.class);
        startActivity(intent);
        finish();
    }
}
