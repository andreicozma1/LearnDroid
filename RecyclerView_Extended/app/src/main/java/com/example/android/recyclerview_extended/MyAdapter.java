package com.example.android.recyclerview_extended;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    // Define an array list which will hold the items passed from MainActivity.java
    ArrayList<String> my_data_set;

    // Adapter constructor which sets the previously defined ArrayList to the values passed from MainActivity.java
    public MyAdapter(ArrayList new_data_set) {
        my_data_set = new_data_set;
    }

    // A setter function which we can call from MainActivity.java in order to dynamically change the items within the RecyclerView
    void setItems(ArrayList new_data_set){
        my_data_set = new_data_set;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // this function gets called for each element part of our list that gets created, based on getItemCount() below

        // Uses a layout inflater to inflate the item.xml into a view object
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View inflated_view = inflater.inflate(R.layout.list_item, null);
        // Then we can use the view object by passing it into our previously created MyViewHolder class
        MyViewHolder view_holder_instance = new MyViewHolder(inflated_view);

        // SET ON CLICK LISTENER CAN ALSO BE SET HERE

        // Finally, return the view holder which we created in order to continue to onBindViewHolder
        return view_holder_instance;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // This function gets called after creating a view holder and 'binds' it to the RecyclerView so we can see it
        // This is where we set and manipulate the individual elements of our view holder, which includes setting texts, images, etc.
        holder.my_text_view.setText(my_data_set.get(position));
        holder.my_image_view.setImageResource(R.mipmap.ic_launcher_round);

        // SET ON CLICK LISTENER CAN ALSO BE SET HERE
    }

    @Override
    public int getItemCount() {
        return my_data_set.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        // Define a variable for each element which we want to change within our view holder.
        // These are elements part of item.xml which we gave IDs to
        ImageView my_image_view;
        TextView my_text_view;
        Switch my_switch;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // set the previously created objects to reference the ID which we defined in item.xml
            my_image_view = itemView.findViewById(R.id.my_image_id);
            my_text_view = itemView.findViewById(R.id.my_text_id);
            my_switch = itemView.findViewById(R.id.my_switch_id);

            // SET ON CLICK LISTENER CAN BE SET HERE OR IN THE PLACES ABOVE
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Clicked " + my_text_view.getText(), Toast.LENGTH_SHORT).show();
                }
            });
            my_image_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Clicked image on " + my_text_view.getText(), Toast.LENGTH_SHORT).show();
                }
            });

            my_switch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Clicked switch on " + my_text_view.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
