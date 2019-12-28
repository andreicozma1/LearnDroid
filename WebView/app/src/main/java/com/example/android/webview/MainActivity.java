package com.example.android.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button example_one_obj;
    Button example_two_obj;
    Button example_three_obj;
    Button example_four_obj;
    Button example_five_obj;
    Button example_six_obj;
    Button example_seven_obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        example_one_obj   = findViewById(R.id.example_one_id);
        example_two_obj   = findViewById(R.id.example_two_id);
        example_three_obj = findViewById(R.id.example_three_id);
        example_four_obj = findViewById(R.id.example_four_id);
        example_five_obj = findViewById(R.id.example_five_id);
        example_six_obj = findViewById(R.id.example_six_id);
        example_seven_obj = findViewById(R.id.example_seven_id);

        example_one_obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my_intent = new Intent(MainActivity.this, WebViewActivity_ex1.class);
                startActivity(my_intent);
            }
        });

        example_two_obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my_intent = new Intent(MainActivity.this, WebViewActivity_ex2.class);
                startActivity(my_intent);
            }
        });

        example_three_obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my_intent = new Intent(MainActivity.this, WebViewActivity_ex3.class);
                startActivity(my_intent);
            }
        });

        example_four_obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my_intent = new Intent(MainActivity.this, WebViewActivity_ex4.class);
                startActivity(my_intent);
            }
        });

        example_five_obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my_intent = new Intent(MainActivity.this, WebViewActivity_ex5.class);
                startActivity(my_intent);
            }
        });

        example_six_obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my_intent = new Intent(MainActivity.this, WebViewActivity_ex6.class);
                startActivity(my_intent);
            }
        });

        example_seven_obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my_intent = new Intent(MainActivity.this, WebViewActivity_ex7.class);
                startActivity(my_intent);
            }
        });

    }
}
