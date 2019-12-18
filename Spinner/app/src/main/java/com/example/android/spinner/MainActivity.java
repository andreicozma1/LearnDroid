package com.example.android.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Spinner my_spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gets a reference to our my_spinner element from layout
        my_spinner = (Spinner) findViewById(R.id.my_spinner);

        final ArrayList<String> items = new ArrayList<String>();
        // Populates the items ArrayList
        for(int i = 1; i <= 100; i++){
            items.add("Item #" + i);
        }

        // Creates an array adapter which takes in the items ArrayList and the layout that each item should use
        ArrayAdapter<String> my_adapter = new ArrayAdapter<String>(this,R.layout.list_item,items);

        // Sets the adapter of the my_spinner to my_adapter
        my_spinner.setAdapter(my_adapter);

        // Sets up OnClickListeners for when items are clicked
        my_spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Selected: " + items.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
