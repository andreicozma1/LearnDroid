package com.example.android.intents_explicit_data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    Button main_btn_object;
    TextView extra_data_object;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // sets up activity_second.xml layout members from their ID
        main_btn_object = (Button) findViewById(R.id.main_btn_id);
        extra_data_object = (TextView) findViewById(R.id.extra_data_id);

        // gets the intent passed from MainActivity
        Intent my_passed_intent = getIntent();
        // checks if the value we are asking for ("key") exists
        if(my_passed_intent.hasExtra("key")){
            // if "key" exists, set the text view to the value associated with the key
            String passed_value = my_passed_intent.getStringExtra("key");
            extra_data_object.setText(passed_value);
        }

        // Sets the Click Listener and Intent for going back to the Main Activity
        main_btn_object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
