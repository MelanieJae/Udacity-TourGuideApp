package com.example.melanieh.tourguideapp;

import android.content.Intent;
import android.content.res.Configuration;
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

public class OutdoorActivity extends AppCompatActivity {

    //    String locname = "Walter Peak Country Farm";
//    String locaddress = "Walter Peak 9793";
    private String tag = "OutdoorActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_category);

        //array list
        ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location("Kawarau River Bridge Bungy Jump", R.drawable.outdoor_bungy,
                R.drawable.outdoor_bungy_2, "State Highway 6, Gibbston Valley, Queenstown 9384",
                "https://www.ajhackett.com"));
        locations.add(new Location("Ben Lomond Track", R.drawable.outdoor_ben_lomond_walkway,
                R.drawable.outdoor_ben_lomond_2, "Brecon St., Queenstown, 9371",
                "http://www.doc.govt.nz/parks-and-recreation/places-to-go/otago/places/" +
                "queenstown-area/things-to-do/ben-lomond-track"));
        locations.add(new Location("Shotover River Jet Boat Ride", R.drawable.outdoor_shotover_jet,
                R.drawable.outdoor_shotover_2, "Gorge Rd, Queenstown 9300", "https://www.shotoverjet.com"));
        locations.add(new Location("Otago Rail Trail Cycling", R.drawable.outdoor_otago_trail,
                R.drawable.outdoor_otago_trail_2, "Lauder 9377", "https://www.otagocentralrailtrail.co.nz"));

        LocationAdapter adapter =
                new LocationAdapter(this, locations);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        final ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.card_category);
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.card_category);
        }


    }
}
