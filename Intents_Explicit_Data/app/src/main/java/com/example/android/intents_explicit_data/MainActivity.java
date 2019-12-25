package com.example.android.intents_explicit_data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button second_btn_object;
    EditText edit_text_object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main);

        second_btn_object = (Button) findViewById(R.id.second_btn_id);
        edit_text_object = (EditText) findViewById(R.id.my_edit_text_id);
        second_btn_object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text input by the use in the text box and convert it to a string
                String val = edit_text_object.getText().toString();
                // Create an intent for transitioning from the context of MainActivity to the Second activity class
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // putExtra is key-value pair. Name your key the same as you want to retrieve it
                intent.putExtra("key", val);
                // start the activity
                startActivity(intent);
            }
        });
    }
}
