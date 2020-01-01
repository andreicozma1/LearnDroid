package com.example.android.intentfilters_applauncher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LauncherActivity extends AppCompatActivity {


    Button my_icon;
    TextView my_app_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        my_icon = findViewById(R.id.my_app_icon);
        my_app_text = findViewById(R.id.my_app_text);

        my_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String package_name_from_settings = SettingsActivity.defaultPackage;
                Toast.makeText(LauncherActivity.this, "Clicked on " + package_name_from_settings, Toast.LENGTH_SHORT).show();
                Intent open_app_intent = getPackageManager().getLaunchIntentForPackage(package_name_from_settings);
                if(open_app_intent != null){
                    startActivity(open_app_intent);
                } else{
                    Toast.makeText(LauncherActivity.this, package_name_from_settings + " not found", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Settings");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getTitle() == "Settings"){
            Intent settings_intent = new Intent(this,SettingsActivity.class);
            startActivity(settings_intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        return;
    }
}
