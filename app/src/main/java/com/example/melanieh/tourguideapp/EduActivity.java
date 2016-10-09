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

public class EduActivity extends AppCompatActivity {

    private String tag = "EduActivity";
    /** for storing listview items and adapter during execution
     * of onSavedInstanceState */
    private static final String STATE_ITEMS = "listItems";
    public ArrayList<Location> locations;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_category);

        //ArrayList and adapter
        ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(R.string.edu_1_name, R.drawable.edu_wanaka_jet_boat,
                R.string.edu_1_address, R.string.edu_1_url));
        locations.add(new Location(R.string.edu_2_name, R.drawable.edu_lotr_tour,
                R.string.edu_2_address, R.string.edu_2_url));
        locations.add(new Location(R.string.edu_3_name, R.drawable.edu_arrowtown,
                R.string.edu_3_address, R.string.edu_3_url));
        locations.add(new Location(R.string.edu_4_name, R.drawable.edu_maori_haka,
                R.string.edu_4_address, R.string.edu_4_url));

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
