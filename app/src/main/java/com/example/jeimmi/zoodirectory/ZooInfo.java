package com.example.jeimmi.zoodirectory;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Jeimmi on 2/23/16.
 */
public class ZooInfo extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        TextView name = (TextView) findViewById(R.id.info_title);
        TextView info_detail = (TextView) findViewById(R.id.info_detail);
        Button call_button = (Button) findViewById(R.id.call_button);

        name.setText("California Zoo");
        info_detail.setText(getString(R.string.zoo_info));

        call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:888-8888"));
                startActivity(intent);
            }
        });


    }
}