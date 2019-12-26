package com.example.android.intents_explicit_basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    Button main_btn_object;
    Button finish_btn_object;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        main_btn_object = (Button) findViewById(R.id.main_btn_id);
        finish_btn_object = (Button) findViewById(R.id.finish_btn_id);
        main_btn_object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);

                // NOTICE THAT THIS KEEPS ON STARTING ACTIVITY AFTER ACTIVITY
                // YOU CAN SEE THAT BY PRESSING THE BACK BUTTON REPEATEDLY AFTER OPENING ACTIVITIES
                // IN ORDER TO SIMULATE THE BACK BUTTON BY GOING TO THE PREVIOUS ACTIVITY, CALL finish()
                // IN ORDER TO KILL SecondActivity AND GO BACK TO MainActivity
            }
        });

        finish_btn_object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // KILLS SecondActivity AND GOES BACK TO PREVIOUSLY OPENED ACTIVITY
                finish();
            }
        });

    }
}
