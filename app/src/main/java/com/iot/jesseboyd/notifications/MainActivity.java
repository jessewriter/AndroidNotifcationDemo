package com.iot.jesseboyd.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification; //let's me build a notification

    private static final int uniqueID = 45612; // random number to identify this notification

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true); //clears old notifications

    }

    public void notifyButtonClicked(View view){
        //build the notification
        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setTicker("this is Jesse's Ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Jesse Notification Title");
        //notification.setContentInfo("I am the content info, hi JB!");
        notification.setContentText("I am the content info, hi JB!");


        //where to send after clicking notification
        Intent intent = new Intent(this, MainActivity.class);
        //allow intent from outside this activity
        //gives my phone access to the intents in this app
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //builds notification and sends it
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(uniqueID, notification.build());
    }




}
