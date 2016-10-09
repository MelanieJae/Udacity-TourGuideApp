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

public class OutdoorActivity extends AppCompatActivity {


    private String LOG_TAG = OutdoorActivity.class.getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_category);

        //array list
        ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(R.string.od_1_name, R.drawable.outdoor_bungy,
                R.string.od_1_address,
                R.string.od_1_url));
        locations.add(new Location(R.string.od_2_name, R.drawable.outdoor_ben_lomond_walkway,
                 R.string.od_2_address, R.string.od_2_url));
        locations.add(new Location(R.string.od_3_name, R.drawable.outdoor_otago_trail,
                 R.string.od_3_address, R.string.od_3_url));


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
                Uri webpage = Uri.parse(url);
                Intent goToURL = new Intent(Intent.ACTION_VIEW, webpage);
                if (goToURL.resolveActivity(getPackageManager()) != null) {
                    startActivity(goToURL);
                }
            }
        });
    }

}
