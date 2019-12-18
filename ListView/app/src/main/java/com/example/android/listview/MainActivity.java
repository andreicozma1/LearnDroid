package com.example.android.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView my_list_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gets a reference to our list_view element from layout
        my_list_view = (ListView) findViewById(R.id.my_list_view);

        final ArrayList<String> items = new ArrayList<String>();
        // Populates the items ArrayList
        for(int i = 1; i <= 100; i++){
            items.add("Item #" + i);
        }

        // Creates an array adapter which takes in the items ArrayList and the layout that each item should use
        ArrayAdapter<String> my_adapter = new ArrayAdapter<String>(this,R.layout.list_item, items);

        // Sets the adapter of the list_view to my_adapter
        my_list_view.setAdapter(my_adapter);

        // Sets up OnClickListeners for when items are clicked
        my_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Selected: " + items.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
