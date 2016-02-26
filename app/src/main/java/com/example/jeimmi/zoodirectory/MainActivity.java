package com.example.jeimmi.zoodirectory;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    int i;
    String[] animals = {"Panda", "Gorilla", "Elephant", "Giraffe", "Lion"};
    int[] info = {R.string.panda_info, R.string.gorilla_info, R.string.elephant_info, R.string.giraffe_info, R.string.lion_info};
    int[] icons = {R.drawable.panda_icon, R.drawable.gorilla_icon, R.drawable.elephant_icon, R.drawable.giraffe_icon, R.drawable.lion_icon};
    int[] images = {R.drawable.panda, R.drawable.gorilla, R.drawable.elephant, R.drawable.giraffe, R.drawable.lion};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(new AnimalListing(this, R.layout.costum_row, animals, icons));

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == (animals.length - 1)) {
                    i = position;

                    showAlertDialog(MainActivity.this);

                } else {
                    Intent intent = new Intent(MainActivity.this, AnimalDetail.class);
                    intent.putExtra("name", animals[position]);
                    intent.putExtra("info", info[position]);
                    intent.putExtra("image", images[position]);
                    startActivity(intent);
                }
            }
        });
    }


    public void showAlertDialog(MainActivity mainactivity) {
        AlertDialog.Builder theDialog = new AlertDialog.Builder(mainactivity);
        theDialog.setTitle("Scary Animal");
        theDialog.setMessage("This animal is very scary. Do you still want to proceed?");
        theDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, AnimalDetail.class);
                intent.putExtra("name", animals[i]);
                intent.putExtra("info", info[i]);
                intent.putExtra("image", images[i]);
                startActivity(intent);
            }
        });
        theDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        theDialog.create().show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    switch (id) {
        case R.id.action_info:
            Intent intent = new Intent(MainActivity.this, ZooInfo.class);
            startActivity(intent);
            break;
        case R.id.action_uninstall:
            Uri packageURI = Uri.parse("package:com.example.jeimmi.zoodirectory");
            Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
            startActivity(uninstallIntent);
            break;
        }

    return super.onOptionsItemSelected(item);
    }
}
