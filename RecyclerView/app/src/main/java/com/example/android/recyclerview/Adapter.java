package com.example.android.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    // Define an array list which will hold the items passed from MainActivity.java
    ArrayList<String> list_items;

    // Adapter constructor which sets the previously defined ArrayList to the values passed from MainActivity.java
    Adapter(ArrayList my_items_list){
        list_items = my_items_list;
    }

    // Define our own ViewHolder class which extends a basic RecyclerView.ViewHolder
    // For each individual element that gets put into our RecyclerView, an instance of the MyViewHolder class gets created
    // Ex: For 100 items, there are 100 instances of this class
    class MyViewHolder extends RecyclerView.ViewHolder{
        // Define a variable for each element which we want to change within our view holder.
        // These are elements part of item.xml which we gave IDs to
        TextView my_text_view;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // set the my_text_view object to reference the ID which we defined in item.xml
            my_text_view = itemView.findViewById(R.id.item_text_id);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // this function gets called for each element part of our list that gets created, based on getItemCount() below

        // Uses a layout inflater to inflate the item.xml into a view object
        View inflated_item_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,null);
        // Then we can use the view object by passing it into our previously created MyViewHolder class
        MyViewHolder new_view_holder = new MyViewHolder(inflated_item_view);
        // Finally, return the view holder which we created in order to continue to onBindViewHolder
        return new_view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // This function gets called after creating a view holder and 'binds' it to the RecyclerView so we can see it
        // This is where we set and manipulate the individual elements of our view holder, which includes setting texts, images, etc.
        holder.my_text_view.setText(list_items.get(position));
    }

    @Override
    public int getItemCount() {
        // Simply returns the size of our data set
        return list_items.size();
    }

    // A setter function which we can call from MainActivity.java in order to dynamically change the items within the RecyclerView
    void setListItems(ArrayList new_list_items){
        list_items = new_list_items;
        notifyDataSetChanged();
    }
}
