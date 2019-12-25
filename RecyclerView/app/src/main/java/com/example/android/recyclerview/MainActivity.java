package com.example.android.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Defines a recycler view object to be used with the one defined within activity_main.xml
    RecyclerView my_recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // sets the recycler view object to the ID defined within activity_main.xml
        my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_id);

        ArrayList<String> list_items = new ArrayList<>();
        // populate an ArrayList with example items to be displayed within our recycler view
        for(int i = 1; i <= 100; i++){
            list_items.add("Item " + i);
        }

        // Initializes a new instance of our adapter class which we created, and pass the list of items
        Adapter my_adapter = new Adapter(list_items);

        // Set the adapter and a linear layout manager on the recycler view to populate it with items
        my_recycler_view.setAdapter(my_adapter);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this));

    }
}
