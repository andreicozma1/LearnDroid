package com.example.android.applicationclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("ANDREI_ACTIVITY", "MainActivity has started ");
        Log.v("ANDREI_ACTIVITY", My_App_Class.str_example);
    }
}
