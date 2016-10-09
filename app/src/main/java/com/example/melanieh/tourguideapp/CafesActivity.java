package com.example.melanieh.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by melanieh on 8/30/16.
 */

public class CafesActivity extends AppCompatActivity {

    private String tag = "CafesActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_category);

        //ArrayList and adapter
        ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(R.string.cafe_1_name, R.drawable.cafe_cafe_halo,
                R.string.cafe_1_address, R.string.cafe_1_url));
        locations.add(new Location(R.string.cafe_2_name, R.drawable.cafe_vudu_larder,
                 R.string.cafe_2_address, R.string.cafe_2_url));
        locations.add(new Location(R.string.cafe_3_name, R.drawable.cafe_lone_star,
                R.string.cafe_3_address, R.string.cafe_3_url));;

        LocationAdapter adapter =
                new LocationAdapter(this, locations);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        //clickListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listView.getItemAtPosition(i);

                TextView urlView = (TextView) listView.findViewById(R.id.location_url);
                String url = urlView.getText().toString();
                Log.v(tag, "url= " + url);
                Uri webpage = Uri.parse(url);
                Intent goToURL = new Intent(Intent.ACTION_VIEW, webpage);
                if (goToURL.resolveActivity(getPackageManager()) != null) {
                    startActivity(goToURL);
                }
            }
        });
    }

}