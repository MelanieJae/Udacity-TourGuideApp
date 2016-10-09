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

        String currentName = getContext().getResources().getString(currentLocation.getNameId());

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.location_name);
        nameTextView.setText(currentName);

        //ImageView 1 (portrait and landscape card image 1)
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.location_img);
        imageView.setImageResource(currentLocation.getImageAssetId());

        String currentAddress = getContext().getResources().getString(currentLocation.getAddressId());

        TextView addressTextView = (TextView) listItemView.findViewById(R.id.location_address);
        addressTextView.setText(currentAddress);

        String currentURL = getContext().getResources().getString(currentLocation.getURLId());
        TextView urlView = (TextView)listItemView.findViewById(R.id.location_url);
        urlView.setText(currentURL);

        return listItemView;
    }

}
