package com.example.foregroundservicesdemo;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class MyApp extends Application {

    public static final String CHANNEL_ID = "Foreground Example";
    public static final String INPUT_KEY = "InputType";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotification();

    }

    private void createNotification() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel nc = new NotificationChannel(CHANNEL_ID, "Foreground", NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager nm = getSystemService(NotificationManager.class);

            nm.createNotificationChannel(nc);;
        }

    }
}
