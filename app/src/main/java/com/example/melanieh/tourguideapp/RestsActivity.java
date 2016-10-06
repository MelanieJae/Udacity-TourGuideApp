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

public class RestsActivity extends AppCompatActivity {

//    String locname = "Walter Peak Country Farm";
//    String locaddress = "Walter Peak 9793";
    private String tag = "RestsActivity";

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.card_category);

            //array list
            ArrayList<Location> locations = new ArrayList<Location>();
            locations.add(new Location("Fergburger", R.drawable.rest_fergburger, R.drawable.rest_fergburger_2, "42 Shotover St.," +
                    "Queenstown, 9300", "http://www.fergburger.com"));
            locations.add(new Location("Botswana Butchery", R.drawable.rest_botswana_butchery,
                    R.drawable.rest_botswana_butchery_2,
                    "17 Marine Parade, Queenstown East, 9300", "https://www.botswanabutchery.co.nz"));
            locations.add(new Location("Rata", R.drawable.rest_rata, R.drawable.rest_rata_2, "43 Ballarat Street, Queenstown 9348",
                    "http://www.ratadining.co.nz"));
            locations.add(new Location("Winnie's", R.drawable.rest_winnies_1, R.drawable.rest_winnies_2,
                    "7-9 The Mall, Queenstown 9348", "http://www.winnies.co.nz"));

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



