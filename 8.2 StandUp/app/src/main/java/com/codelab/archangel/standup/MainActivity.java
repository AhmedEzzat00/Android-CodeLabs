package com.codelab.archangel.standup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private NotificationManager mNotificationManger;
    private static final int NOTIFICATION_ID = 0;
    private static final String PRIMARY_ID = "primary_notification_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleButton alarmToggle = findViewById(R.id.alarmToggle);
        alarmToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                String message;
                if (isChecked)
                {
                    message = " Stand Up Alarm is ON!";
                    deliverNotification(MainActivity.this);
                }
                else
                {
                    message = "Stand Up Alarm is OFF";
                    mNotificationManger.cancelAll();
                }

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
        createNotificationChannel();
    }

    public void createNotificationChannel() {
        mNotificationManger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_ID,
                    "Stand Up Notification",NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.YELLOW);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("15 minutes Passed, Stand UP NOW!");
            mNotificationManger.createNotificationChannel(notificationChannel);
        }
    }

    private void deliverNotification(Context context){
        Intent intent=new Intent(context,MainActivity.class);
        PendingIntent contentPendingIntent= PendingIntent.getActivity(context,NOTIFICATION_ID,intent
        ,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,PRIMARY_ID)
                .setSmallIcon(R.drawable.ic_face)
                .setContentTitle(getString(R.string.notification_title))
                .setContentText(getString(R.string.notification_text))
                .setContentIntent(contentPendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        mNotificationManger.notify(NOTIFICATION_ID,builder.build());
    }
}