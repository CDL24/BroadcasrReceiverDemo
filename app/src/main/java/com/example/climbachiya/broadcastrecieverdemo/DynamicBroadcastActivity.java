package com.example.climbachiya.broadcastrecieverdemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Calendar;

/**
 * Created by C.limbachiya on 4/22/2016.
 */
public class DynamicBroadcastActivity extends AppCompatActivity {

    IntentFilter intentFilter = null;
    MyBroadcastReceiver receiver = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_broadcast);

        initClassObject();

    }

    private void initClassObject() {
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.climbachiya.DYNAMIC_BROADCAST");

        receiver = new MyBroadcastReceiver();
    }

    public void registerReceiver(View v) {
        registerReceiver(receiver, intentFilter);
    }

    public void sendBroadcast(View v) {

        Calendar cal = Calendar.getInstance();

        String date = "" + cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);

        String time = "" + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE);

        Intent intent = new Intent();
        intent.setAction("com.example.climbachiya.DYNAMIC_BROADCAST");
        intent.putExtra("TIME", time);
        intent.putExtra("BROADCAST_TYPE","Dynamic");
        sendBroadcast(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (null != receiver)
            unregisterReceiver(receiver);
    }
}
