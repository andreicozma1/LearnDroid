package com.example.android.notificationchannels;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class MyApp extends Application {
    // Declare the IDs as public and static so we can reference them from any other class
    // final so we can't accidentally change them
    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";
    public static final String CHANNEL_3_ID = "channel3";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotifChannels();
    }

    private void createNotifChannels() {
        // This piece of code is only relevant if above the required SDK level
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            // Create channels with different importance levels for each channel.
            // These channels can reflect notifications from different parts of the app, so the user can control or turn off whichever parts he desires.
            NotificationChannel channel_1 = new NotificationChannel(CHANNEL_1_ID, "My Channel 1", NotificationManager.IMPORTANCE_HIGH);
            NotificationChannel channel_2 = new NotificationChannel(CHANNEL_2_ID, "My Channel 2", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationChannel channel_3 = new NotificationChannel(CHANNEL_3_ID, "My Channel 3", NotificationManager.IMPORTANCE_MIN);

            // gets the notification manager system service instance and creates the channels based on their definitions above
            NotificationManager my_notif_manager = getSystemService(NotificationManager.class);
            my_notif_manager.createNotificationChannel(channel_1);
            my_notif_manager.createNotificationChannel(channel_2);
            my_notif_manager.createNotificationChannel(channel_3);
        }
    }
}
