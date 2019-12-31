package com.example.android.intentfilters_applauncher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button my_icon;
    TextView my_app_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_icon = findViewById(R.id.my_app_icon);
        my_app_text = findViewById(R.id.my_app_text);

        my_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicked on " + SettingsActivity.et_package.getText(), Toast.LENGTH_SHORT).show();

                Intent my_intent = getPackageManager().getLaunchIntentForPackage(SettingsActivity.et_package.getText().toString());
                startActivity(my_intent);
            }
        });

    }
}
