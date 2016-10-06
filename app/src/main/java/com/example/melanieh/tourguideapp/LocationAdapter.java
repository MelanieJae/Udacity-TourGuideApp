package com.example.melanieh.tourguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by melanieh on 8/30/16.
 */

public class LocationAdapter extends ArrayAdapter<Location> {

    private String debug_tag="Rests Activity";

    public LocationAdapter(Context context, List<Location> objects) {
        // resourceId=0 to override single textview that is standard for the ArrayAdapter superclass
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        //if the convertView (now a ListView) is empty, it gets inflated via this if statement
        // containing a LayoutInflater
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item,
                    parent, false);
        }
        // get the Word object item located at a certain position in the ArrayList
        Location currentLocation = getItem(position);
        Log.v(debug_tag, "Current location: " + currentLocation);

        // find the TextView where the first state in the Word class object is used to set the text,
        // i.e. the TextView where the miwok word will go...
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.location_name);
        //... and set its text attribute (i.e. the Miwok word that will appear in the view)
        nameTextView.setText(currentLocation.getName());

//      //ImageView where the list item icon is to be shown
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.location_img);
        imageView.setImageResource(currentLocation.getImageAssetId());

//        //ImageView where the list item icon is to be shown
        ImageView image2View = (ImageView) listItemView.findViewById(R.id.location_img_2);
        image2View.setImageResource(currentLocation.getImage2AssetId());

        // find the TextView where the second state in the Word class object is used to set the text,
        // i.e. the TextView where the default/English word will go
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.location_address);
        //...and set its text attribute (i.e. the default/English word that will appear in the view)
        addressTextView.setText(currentLocation.getAddress());

        TextView urlView = (TextView)listItemView.findViewById(R.id.location_url);
        urlView.setText(currentLocation.getURL());

        return listItemView;
    }
}
