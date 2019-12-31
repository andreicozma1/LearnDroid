package com.example.android.intentfilters_applauncher;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {


    public static EditText et_package;
    Button btn_pref;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        et_package = findViewById(R.id.et_package_id);
        btn_pref = findViewById(R.id.btn_pref_id);

        btn_pref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pref_intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,Uri.fromParts("package",getPackageName(),null));
                startActivity(pref_intent);
            }
        });
    }
}
