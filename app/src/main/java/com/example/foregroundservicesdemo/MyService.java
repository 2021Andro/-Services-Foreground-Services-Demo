package com.example.foregroundservicesdemo;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String name = intent.getStringExtra(MyApp.INPUT_KEY);

        Intent intent1 = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent1, 0);

        Notification notification = new NotificationCompat.Builder(this, MyApp.CHANNEL_ID)
                .setContentTitle("My Title")
                .setContentText(name)
                .setSmallIcon(R.drawable.ic_android_black_24dp)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1, notification);



        return START_NOT_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
