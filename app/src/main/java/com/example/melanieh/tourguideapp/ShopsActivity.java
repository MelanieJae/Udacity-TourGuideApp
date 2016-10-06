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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by melanieh on 8/30/16.
 */

public class ShopsActivity extends AppCompatActivity {

    private String tag = "ShopsActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_category);

        //array list
        ArrayList<Location> locations = new ArrayList<Location>();

        locations.add(new Location("O'Connell's Shopping Centre", R.drawable.shop_oconnells, R.drawable.shop_oconnells_2,
                "Corner of Camp and Beach Sts., Queenstown, 9348", "http://www.oconnells.net.nz"));
        locations.add(new Location("Remarkables Park Town Centre", R.drawable.shop_remarkables_park, R.drawable.shop_remarkables_park_2,
                "Hawthorne Dr., Frankton, 9300", "http://www.remarkablesparktowncentre.co.nz"));
        locations.add(new Location("FreshChoice Queenstown", R.drawable.shop_freshchoice, R.drawable.shop_freshchoice_2,
                "64 Gorge Rd, Queenstown 9348", "http://freshchoice.co.nz"));
        locations.add(new Location("The Black Cat Bookshop", R.drawable.shop_black_cat_alt, R.drawable.shop_black_cat_2,
                "Camp St., Queenstown, 9793", "http://blackcat-bookshop.myshopify.com"));
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


