package com.componets5;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

public class ForegroundService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();

        String channelId = "haha1";

        System.out.println("KeFeng ForegroundService onCreate");

        Intent intent = new Intent(this, HomeActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationChannel channel = new NotificationChannel(channelId, "haha2", NotificationManager.IMPORTANCE_NONE);
        channel.setLightColor(Color.BLUE);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        Notification notification = new NotificationCompat.Builder(this, channelId)
                                            .setContentTitle("KeFeng Title")
                                            .setContentText("KeFeng Text")
                                            .setSmallIcon(R.drawable.ic_menu_camera)
                                            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_menu_gallery))
                                            .setContentIntent(pi)
                                            .setDefaults(1)
                                            .build();

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
        notificationManager.notify(1, notification);

        startForeground(1, notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
