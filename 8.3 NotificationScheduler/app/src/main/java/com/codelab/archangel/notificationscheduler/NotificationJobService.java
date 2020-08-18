package com.codelab.archangel.notificationscheduler;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class NotificationJobService extends JobService {

    private static final int NOTIFICATION_ID = 0;
    private NotificationManager mNotificationManger;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";

    public NotificationJobService() {
    }


    @Override
    public boolean onStartJob(JobParameters params) {
        createNotificationChannel();

        PendingIntent contentPendingIntent= PendingIntent.getActivity(this,NOTIFICATION_ID
        ,new Intent(this,MainActivity.class),PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,PRIMARY_CHANNEL_ID)
                .setContentTitle(getString(R.string.notify_title))
                .setContentText(getString(R.string.notify_text))
                .setContentIntent(contentPendingIntent)
                .setSmallIcon(R.drawable.ic_job_running)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true);
        mNotificationManger.notify(NOTIFICATION_ID,builder.build());
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        //if the job fails, you want the job to be rescheduled instead of dropped.
        return true;
    }

    private void createNotificationChannel() {
        mNotificationManger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID
                    , "Job Service Notification", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableVibration(true);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.BLUE);
            notificationChannel.setDescription("Notification From Job Service");
            mNotificationManger.createNotificationChannel(notificationChannel);
        }
    }
}
