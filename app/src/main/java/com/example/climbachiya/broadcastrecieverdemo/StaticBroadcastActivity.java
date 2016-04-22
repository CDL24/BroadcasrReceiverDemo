package com.example.climbachiya.broadcastrecieverdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

/**
 * Created by C.limbachiya on 4/22/2016.
 */
public class StaticBroadcastActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.static_broadcast_receiver);

    }

    public void sendBroadCastReceiver(View v){
        Calendar cal = Calendar.getInstance();

        String date = "" + cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);

        String time = "" + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE);

        Intent intent = new Intent(this,MyBroadcastReceiver.class);
        intent.putExtra("TIME", time);
        intent.putExtra("BROADCAST_TYPE","Static");
        sendBroadcast(intent);

    }
}
