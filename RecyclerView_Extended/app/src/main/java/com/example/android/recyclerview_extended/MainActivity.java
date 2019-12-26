package com.example.android.recyclerview_extended;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> list_items;
    RecyclerView my_recycler_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_id);

        // Initialize and populate the ArrayList with items
        list_items = new ArrayList<String>();
        for (int i = 1; i <= 100; i++){
            list_items.add("Item " + i);
        }

        // Set to true to improve performance on fixed data sets
        my_recycler_view.setHasFixedSize(true);
        my_recycler_view.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        // Sets the original data set to the names_arr through the MyAdapter constructor.
        MyAdapter adapter = new MyAdapter(list_items);
        // Set the newly created adapter and layour manager
        my_recycler_view.setAdapter(adapter);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this));
    }
}
