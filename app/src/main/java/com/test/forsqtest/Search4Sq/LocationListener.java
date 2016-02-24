package com.test.forsqtest.Search4Sq;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import java.lang.ref.WeakReference;

/**
 * Created by Hiciu on 2/24/2016.
 */
public class LocationListener implements android.location.LocationListener {

    Location location; // location
    double latitude; // latitude
    double longitude; // longitude

    // The minimum distance to change Updates in meters
    private static final long LOCATION_REFRESH_DISTANCE = 1; // meters

    // The minimum time between updates in milliseconds
    private static final long LOCATION_REFRESH_TIME = 10; // miliseconds

    private WeakReference<ISearchView> mView;

    public LocationListener(Context context, ISearchView view) {
        setupLocation(context);
        mView = new WeakReference<ISearchView>(view);

    }

    private void setupLocation(Context context) {
        LocationManager locationManager = ((LocationManager) context.getSystemService(context.LOCATION_SERVICE));
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, LOCATION_REFRESH_TIME, LOCATION_REFRESH_DISTANCE, this);
        onLocationChanged(locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER));
    }

    @Override
    public void onLocationChanged(final Location location) {
        //your code here
        if (location != null && mView.get() != null) {
            mView.get().onLocationUpdated(location);
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
