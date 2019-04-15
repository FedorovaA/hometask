package com.test.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuWearActivity extends WearableActivity {

    private TextView txt_timer;
    private Button btn_start;
    private Button btn_stop;
    private String item;
    private String subStr[];
    long timeStart;
    int timeProcess;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_wear);
        txt_timer = (TextView) findViewById(R.id.txt_timer);
        btn_start = findViewById(R.id.btn_start);
        btn_stop = findViewById(R.id.btn_stop);
        btn_start = findViewById(R.id.btn_start);
        timeProcess = 1000;
        item="";
        btn_start.setOnClickListener(v->{
            if(txt_timer.getText().toString().equals("00:00:00")){
                timeStart = 30000;
            }
            else {
                item = txt_timer.getText().toString();
                subStr = item.split(":");
                timeStart = Long.parseLong(subStr[0])*3600000;
                timeStart+=Long.parseLong(subStr[1])*60000;
                timeStart+=Long.parseLong(subStr[2])*1000;
            }
            countDownTimer = new CountDownTimer(timeStart,timeProcess) {
                @Override
                public void onTick(long millisUntilFinished) {
                    long hour = millisUntilFinished/3600000;
                    long minute = (millisUntilFinished - (hour*3600000))/60000;
                    long sec = (millisUntilFinished -((hour*3600000)+(minute*60000)))/1000;
                    txt_timer.setText(String.valueOf(hour)+":"
                    +String.valueOf(minute)+":"+
                            String.valueOf(sec));
                }
                @Override
                public void onFinish() {
                   AlertDialog.Builder builder =  new AlertDialog.Builder(MenuWearActivity.this)
                            .setTitle("Поздравляем")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            }.start();
        });
        btn_stop.setOnClickListener(v->{
            countDownTimer.cancel();
        });
        // Enables Always-on
        setAmbientEnabled();
    }
}
