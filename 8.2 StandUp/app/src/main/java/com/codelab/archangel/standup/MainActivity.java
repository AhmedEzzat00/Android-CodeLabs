package com.codelab.archangel.standup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
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

        final AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        final Intent notifyIntent = new Intent(this, AlarmReceiver.class);

        //get the status of the ToggleButton form the pending intent of the alarm
        boolean alarmUp = (PendingIntent.getBroadcast(this, NOTIFICATION_ID, notifyIntent,
                PendingIntent.FLAG_NO_CREATE) != null);

        final PendingIntent notifyPendingIntent = PendingIntent.getBroadcast(this, NOTIFICATION_ID
                , notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        ToggleButton alarmToggle = findViewById(R.id.alarmToggle);
        //Set the toggle to the state of the alarm to avoid reset when the app is cloased
        alarmToggle.setChecked(alarmUp);
        alarmToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                String message;
                if (isChecked) {
                    long repeatInterval=AlarmManager.INTERVAL_FIFTEEN_MINUTES;
                    long triggerTime=SystemClock.elapsedRealtime()+repeatInterval;
                    if (alarmManager!=null){
                        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP
                        ,triggerTime,repeatInterval,notifyPendingIntent);
                    }
                    message = " Stand Up Alarm is ON!";

                } else {
                    message = "Stand Up Alarm is OFF";
                    if (alarmManager != null) {
                        alarmManager.cancel(notifyPendingIntent);
                    }
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
                    "Stand Up Notification", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.YELLOW);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("15 minutes Passed, Stand UP NOW!");
            mNotificationManger.createNotificationChannel(notificationChannel);
        }
    }

}