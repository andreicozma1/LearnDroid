package com.example.android.actionbar_navigation_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Button my_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_button = findViewById(R.id.my_button_id);

        // NEEDS MIN API REQUIREMENT OF 21
        Toolbar my_toolbar = findViewById(R.id.my_toolbar_id);
        setActionBar(my_toolbar);

//      ALTERNATIVE APPCOMPAT TOOLBAR IMPLEMENTATION
//      androidx.appcompat.widget.Toolbar my_support_toolbar = findViewById(R.id.my_support_toolbar_id);
//      setSupportActionBar(my_support_toolbar);

    }
}
