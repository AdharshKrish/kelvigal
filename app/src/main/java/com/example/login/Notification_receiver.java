package com.example.login;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

public class Notification_receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent)
    {
        NotificationManager notificationManager=(NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
        Intent repeating_intent= new Intent(context,Repeating_activity.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(context,100,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context).setContentIntent(pendingIntent).setSmallIcon(android.R.drawable.arrow_up_float).setContentTitle("Notification title").setContentText("Notification Text").setAutoCancel(true);
      //  NotificationManager.notify(100,builder.build());
        if (intent.getAction().equals("MY_NOTIFICATION_MESSAGE")) {
            notificationManager.notify(100,builder.build());
    }
}}
