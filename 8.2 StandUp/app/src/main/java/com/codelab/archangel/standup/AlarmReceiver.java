package com.codelab.archangel.standup;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {
    private NotificationManager mNotificationManger;
    private static final int NOTIFICATION_ID = 0;
    private static final String PRIMARY_ID = "primary_notification_channel";
    @Override
    public void onReceive(Context context, Intent intent) {
        mNotificationManger = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        deliverNotification(context);
    }
    private void deliverNotification(Context context){
        Intent intent=new Intent(context,MainActivity.class);
        PendingIntent contentPendingIntent= PendingIntent.getActivity(context,NOTIFICATION_ID,intent
                ,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,PRIMARY_ID)
                .setSmallIcon(R.drawable.ic_face)
                .setContentTitle(context.getString(R.string.notification_title))
                .setContentText(context.getString(R.string.notification_text))
                .setContentIntent(contentPendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        mNotificationManger.notify(NOTIFICATION_ID,builder.build());
    }

}
