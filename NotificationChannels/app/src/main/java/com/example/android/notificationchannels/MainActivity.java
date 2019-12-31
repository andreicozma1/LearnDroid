package com.example.android.notificationchannels;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    NotificationManagerCompat notif_manager;
    Button channel_1_btn;
    Button channel_2_btn;
    Button channel_3_btn;
    Button ch1_ongoing_btn;
    Button ch1_autocancel_btn;

    EditText et_title;
    EditText et_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This time we use the NotificationManagerCompat layer so we can send notifications to
        // any API level even before Channels were introduced.
        // Notifications MUST be part of a channel newer APIs or they will not show up
        notif_manager = NotificationManagerCompat.from(this);

        et_title = findViewById(R.id.et_title_id);
        et_message = findViewById(R.id.et_message_id);

        channel_1_btn = findViewById(R.id.btn_channel_1_id);
        channel_1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendChannel1(et_title.getText().toString(), et_message.getText().toString());
            }
        });

        channel_2_btn = findViewById(R.id.btn_channel_2_id);
        channel_2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendChannel2(et_title.getText().toString(), et_message.getText().toString());
            }
        });

        channel_3_btn = findViewById(R.id.btn_channel_3_id);
        channel_3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendChannel3(et_title.getText().toString(), et_message.getText().toString());
            }
        });

        ch1_ongoing_btn = findViewById(R.id.btn_ch1_ongoing_id);
        ch1_ongoing_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCh1_Ongoing(et_title.getText().toString(), et_message.getText().toString());
            }
        });

        ch1_autocancel_btn = findViewById(R.id.btn_ch1_autocancel_id);
        ch1_autocancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendCh1_AutoCancel(et_title.getText().toString(), et_message.getText().toString());
            }
        });

    }

    void sendChannel1(String title, String message) {

        Toast.makeText(this, "Clicked Ch1", Toast.LENGTH_SHORT).show();

        // The second argument of the Builder is ignored in lower API versions before Channels existed
        NotificationCompat.Builder builder_1 = new NotificationCompat.Builder(this, MyApp.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.num_1)
                .setContentTitle(title)
                .setContentText(message)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE) // ONLY do this if your notification actually fits in one of the categories
                .setPriority(NotificationCompat.PRIORITY_HIGH); // For compatibility with lower API versions

        // A notification with the same ID will replace a previous instance of itself.
        notif_manager.notify(1, builder_1.build());
    }


    void sendChannel2(String title, String message) {
        Toast.makeText(this, "Clicked Ch2", Toast.LENGTH_SHORT).show();

        // The second argument of the Builder is ignored in lower API versions before Channels existed
        NotificationCompat.Builder builder_2 = new NotificationCompat.Builder(this, MyApp.CHANNEL_2_ID)
                .setSmallIcon(R.drawable.num_2)
                .setContentTitle(title)
                .setContentText(message)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE) // ONLY do this if your notification actually fits in one of the categories
                .setPriority(NotificationCompat.PRIORITY_DEFAULT); // For compatibility with lower API versions

        // A notification with the same ID will replace a previous instance of itself.
        notif_manager.notify(2, builder_2.build());
    }


    void sendChannel3(String title, String message) {
        Toast.makeText(this, "Clicked Ch3", Toast.LENGTH_SHORT).show();

        // The second argument of the Builder is ignored in lower API versions before Channels existed
        NotificationCompat.Builder builder_3 = new NotificationCompat.Builder(this, MyApp.CHANNEL_3_ID)
                .setSmallIcon(R.drawable.num_3)
                .setContentTitle(title)
                .setContentText(message)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE) // ONLY do this if your notification actually fits in one of the categories
                .setPriority(NotificationCompat.PRIORITY_MIN); // For compatibility with lower API versions

        // A notification with the same ID will replace a previous instance of itself.
        notif_manager.notify(3, builder_3.build());
    }


    void sendCh1_Ongoing(String title, String message){
        Toast.makeText(this, "Clicked Ch1 Ongoing", Toast.LENGTH_SHORT).show();

        // The second argument of the Builder is ignored in lower API versions before Channels existed
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, MyApp.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.num_1)
                .setContentTitle(title)
                .setContentText(message)
                .setOngoing(true)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE) // ONLY do this if your notification actually fits in one of the categories
                .setPriority(NotificationCompat.PRIORITY_HIGH); // For compatibility with lower API versions

        // A notification with the same ID will replace a previous instance of itself.
        notif_manager.notify(4, builder.build());
    }

    void sendCh1_AutoCancel(String title, String message){
        Toast.makeText(this, "Clicked Ch1 AutoCancel", Toast.LENGTH_SHORT).show();

        // The second argument of the Builder is ignored in lower API versions before Channels existed
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, MyApp.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.num_1)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true) // Dismiss notification when clicked. Content Intent gets executed
                .setContentIntent(PendingIntent.getActivity(this,0,new Intent(), 0)) // Empty intent does nothing
                .setCategory(NotificationCompat.CATEGORY_MESSAGE) // ONLY do this if your notification actually fits in one of the categories
                .setPriority(NotificationCompat.PRIORITY_HIGH); // For compatibility with lower API versions

        // A notification with the same ID will replace a previous instance of itself.
        notif_manager.notify(5, builder.build());
    }
}
