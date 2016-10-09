package com.example.melanieh.tourguideapp;

/**
 * Created by melanieh on 8/30/16.
 */

public class Location {

    // member variables for all constructors
    int mNameId;
    int mAddressId;
    int mImageAssetId;
    int mURLId;

    /*
        * constructor
        *
        * @param nameId= string id for name of location
        *
        * @param imageId=image shown in card
        *
        * @param addressId=string Id for address of location shown in card
        *
        * @param URLId = string id for website link for location
         */

    public Location(int mNameId, int mImageAssetId,int mAddressId, int mURLId) {
        this.mNameId = mNameId;
        this.mImageAssetId = mImageAssetId;
        this.mAddressId = mAddressId;
        this.mURLId = mURLId;
    }

    /* 'getter' methods for member variables */
    public int getNameId() { return mNameId; }
    public int getImageAssetId() { return mImageAssetId; }
    public int getAddressId() { return mAddressId; }
    public int getURLId() { return mURLId; }

//    // This method is only called when landscape layout config. is used
//    public int getImage2AssetId() { return mImage2AssetId; }

    @Override
    public String toString() {
        return "Location{" +
                "mNameId='" + mNameId + '\'' +
                ", mAddressId='" + mAddressId + '\'' +
                ", mImageAssetId=" + mImageAssetId + "mURLId= " + mURLId +
                '}';
    }
}







