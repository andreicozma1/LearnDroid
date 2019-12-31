package com.example.android.notificationchannels;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // get the Extra that was passed through the intent through the key-value pair
        // passed_string is the key, and the message entered by the user is the value passed
        System.out.println("Hereeee");
        String message = intent.getStringExtra("passed_string");

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
