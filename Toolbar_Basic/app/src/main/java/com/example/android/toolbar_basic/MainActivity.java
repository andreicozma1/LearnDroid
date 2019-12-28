package com.example.android.toolbar_basic;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // NEEDS MIN API REQUIREMENT OF 21
        Toolbar my_toolbar = (Toolbar) findViewById(R.id.my_toolbar_id);
//      my_toolbar.setTitle("New title");
//      my_toolbar.setSubtitle("New subtitle");
//      my_toolbar.setLogo(R.mipmap.ic_launcher);
        setActionBar(my_toolbar);


//      ALTERNATIVE APPCOMPAT TOOLBAR IMPLEMENTATION
//      androidx.appcompat.widget.Toolbar my_support_toolbar = findViewById(R.id.my_support_toolbar_id);
//      setSupportActionBar(my_support_toolbar);
    }
}
