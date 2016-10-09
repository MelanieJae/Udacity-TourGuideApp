package com.example.melanieh.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by melanieh on 8/30/16.
 */

public class RestsActivity extends AppCompatActivity {

    private String LOG_TAG = RestsActivity.class.getName();

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.card_category);

            //ArrayList and Adapter
            ArrayList<Location> locations = new ArrayList<Location>();
            locations.add(new Location(R.string.rest_1_name, R.drawable.rest_fergburger,
                     R.string.rest_1_address, R.string.rest_1_url));
            locations.add(new Location(R.string.rest_2_name, R.drawable.rest_botswana_butchery,
                    R.string.rest_2_address, R.string.rest_2_url));
            locations.add(new Location(R.string.rest_3_name, R.drawable.rest_rata, R.string.rest_3_address,
                    R.string.rest_3_url));

            LocationAdapter adapter =
                    new LocationAdapter(this, locations);

            final ListView listView = (ListView) findViewById(R.id.list);
            listView.setAdapter(adapter);

            //clickListener for listView item i.e. cardView
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    listView.getItemAtPosition(i);

                    TextView urlView = (TextView) listView.findViewById(R.id.location_url);
                    String url = urlView.getText().toString();
                    Uri webpage = Uri.parse(url);
                    Intent goToURL = new Intent(Intent.ACTION_VIEW, webpage);
                    if (goToURL.resolveActivity(getPackageManager()) != null) {
                        startActivity(goToURL);
                    }
                }
            });
        }
}



