package com.example.android.applicationclass;

import android.app.Application;
import android.util.Log;

public class My_App_Class extends Application {

    public static String str_example = "My String Example";
    @Override
    public void onCreate() {
        super.onCreate();

        Log.v("ANDREI_APP", "My application has started");
    }



}
