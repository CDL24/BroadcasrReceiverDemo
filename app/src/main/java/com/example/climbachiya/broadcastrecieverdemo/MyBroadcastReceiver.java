package com.example.climbachiya.broadcastrecieverdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.widget.Toast;

/**
 * Created by C.limbachiya on 4/22/2016.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

    int mId = 101;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Receiver called", Toast.LENGTH_SHORT).show();

        if (null != intent) {
            String time = intent.getStringExtra("TIME");
            String type = intent.getStringExtra("BROADCAST_TYPE");

            sendNotification(context, time, type);
        }
    }

    private void sendNotification(Context context, String time, String type) {

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(android.R.drawable.ic_notification_overlay)
                        .setContentTitle("From Broadcast Receiver : "+type)
                        .setContentText("Arrival Time : "+time);
                     // Creates an explicit intent for an Activity in your app
                        Intent resultIntent = new Intent(context, MainActivity.class);

                    // The stack builder object will contain an artificial back stack for the
                    // started Activity.
                    // This ensures that navigating backward from the Activity leads out of
                    // your application to the Home screen.
                        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
                    // Adds the back stack for the Intent (but not the Intent itself)
                        stackBuilder.addParentStack(MainActivity.class);
                    // Adds the Intent that starts the Activity to the top of the stack
                        stackBuilder.addNextIntent(resultIntent);
                        PendingIntent resultPendingIntent =
                                stackBuilder.getPendingIntent(
                                        0,
                                        PendingIntent.FLAG_UPDATE_CURRENT
                                );
                        mBuilder.setContentIntent(resultPendingIntent);
                        mBuilder.setAutoCancel(true);
                        NotificationManager mNotificationManager =
                                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                    // mId allows you to update the notification later on.
                        mNotificationManager.notify(mId, mBuilder.build());
    }
}
