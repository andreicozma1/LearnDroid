package com.example.android.logging;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doJavaLogs();
        doAndroidLogs();
    }

    void doJavaLogs(){
        // Prints a whole line, which ends with a new line character \n
        System.out.println("Printing a line");
        // Prints a string without a new line;
        System.out.print("String1");
        // Notice String1 and String2 then appear on the same line
        // Print String2 but insert a manual line break \n
        System.out.print("String2\n");
        // Notice that String3 is now on the next line.
        System.out.print("String3");
    }
    void doAndroidLogs(){
        // Used for terrible errors that should never happen
        Log.wtf("What a Terrible Failure", "Logging WTF");
        // The rest of log levels sorted by importance
        Log.e("ERROR", "Logging an error!");
        Log.w("WARNING","Logging a warning!");
        Log.i("INFO","Logging info!");
        Log.d("DEBUG","Logging in debug!");
        Log.v("VERBOSE","Logging verbose!");
    }
}
