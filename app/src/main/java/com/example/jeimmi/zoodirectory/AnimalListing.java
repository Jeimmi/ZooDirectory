package com.example.jeimmi.zoodirectory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jeimmi on 2/23/16.
 */

public class AnimalListing extends ArrayAdapter<String> {

    Context context;
    String[] names;
    int[] icons;


    public AnimalListing(Context context, int layout, String[] animals, int[] images) {
        super(context, R.layout.costum_row, animals);
        this.context = context;
        this.names = animals;
        this.icons = images;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater theInflater = LayoutInflater.from(context);
        View theView = theInflater.inflate(R.layout.costum_row, parent, false);


        TextView name = (TextView) theView.findViewById(R.id.rowText);
        name.setText(names[position]);

        ImageView icon = (ImageView) theView.findViewById(R.id.rowImage);
        icon.setImageResource(icons[position]);
        return theView;

    }
}