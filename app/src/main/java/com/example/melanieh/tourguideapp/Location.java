package com.example.melanieh.tourguideapp;

/**
 * Created by melanieh on 8/30/16.
 */

public class Location {

    // member variables for all constructors
    String mName;
    String mAddress;
    int mImageAssetId;
    int mImage2AssetId;
    String mURL;

    /*
        * constructor
        *
        * @param name= name of location
        *
        * @param imageId=image shown in card
        *
        * @param image2Id=2nd image for landscape-oriented cards
        *
        * @param address=address of location shown in card
        *
        * @param URL = website link for location
         */
    public Location(String name, int imageId, int image2Id, String address, String url) {
        this.mName = name;
        this.mImageAssetId = imageId;
        this.mImage2AssetId = image2Id;
        this.mAddress = address;
        this.mURL = url;
    }

    /* 'getter' methods for member variables */
    public String getName() { return mName; }
    public int getImageAssetId() { return mImageAssetId; }
    public String getAddress() { return mAddress; }
    public String getURL() { return mURL; }

    // This method is only called when landscape layout config. is used
    public int getImage2AssetId() { return mImage2AssetId; }

    /* 'setter' methods for member variables */
    public void setName(String name) {this.mName = mName; }
    public void setImageAssetId(int imageAssetId) { this.mImageAssetId = imageAssetId; }
    public void setAddress(String address) {this.mAddress = address; }
    public void setURL(String url) { this.mURL = url; };

    @Override
    public String toString() {
        return "Location{" +
                "mName='" + mName + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mImageAssetId=" + mImageAssetId + "mURL= " + mURL +
                '}';
    }
}







