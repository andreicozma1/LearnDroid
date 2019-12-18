package com.example.android.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static LinearLayout my_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // reference to the linear layout which is inside the ScrollView
        my_list = (LinearLayout) findViewById(R.id.scroll_view);
        addViews();
    }


    public void addViews() {

        for (int i = 1; i <= 100; i++) {
            //gets the view from view.xml and stores it into v, casting it into TextView
            TextView v = (TextView) getLayoutInflater().inflate(R.layout.list_item, null);
            //changes the default text by appending the number of the element
            v.setText("Item #" + i);
            //sets the OnClickListener to the MainActivity class context so onClick is called;
            v.setOnClickListener(this);
            //sets the id to the number of the element so we can use the element later
            v.setId(i);
            //adds the view to the linear layout.
            my_list.addView(v);
        }
    }

    @Override
    public void onClick(View v) {
        //Create a toast with the number of the element clicked based on its id.
        Toast.makeText(this, "Pressed view " + v.getId(), Toast.LENGTH_SHORT).show();
    }
}
