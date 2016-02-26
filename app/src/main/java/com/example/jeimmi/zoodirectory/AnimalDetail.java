package com.example.jeimmi.zoodirectory;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jeimmi on 2/23/16.
 */
public class AnimalDetail extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_detail);

//        Intent intent = new Intent();

        TextView title = (TextView) findViewById(R.id.detail_title);
        ImageView image = (ImageView) findViewById(R.id.detail_image);
        TextView animal_info = (TextView) findViewById(R.id.animal_info);


        title.setText(getIntent().getExtras().getString("name"));
        image.setImageResource(getIntent().getExtras().getInt("image"));
        animal_info.setText(getIntent().getExtras().getInt("info"));


    }
}