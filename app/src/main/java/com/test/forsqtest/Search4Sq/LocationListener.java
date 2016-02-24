package com.test.forsqtest.Search4Sq;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import java.lang.ref.WeakReference;

/**
 * Created by Hiciu on 2/24/2016.
 */
//Class to determine current coordonates of the user and use them to find the
public class LocationListener implements android.location.LocationListener {

    // The minimum distance to change Updates in meters
    private static final long LOCATION_REFRESH_DISTANCE = 1; // meters

    // The minimum time between updates in milliseconds
    private static final long LOCATION_REFRESH_TIME = 10; // miliseconds

    //reference to our hosting activity / fragment
    private WeakReference<ISearchView> mView;

    public LocationListener(Context context, ISearchView view) {
        mView = new WeakReference<ISearchView>(view);
        setupLocation(context);
    }

    //start requesting location updates from both network and or GPS according to predefined parameters
    private void setupLocation(Context context) {
        if (context == null) {
            return;
        }
        LocationManager locationManager = ((LocationManager) context.getSystemService(context.LOCATION_SERVICE));
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, LOCATION_REFRESH_TIME, LOCATION_REFRESH_DISTANCE, this);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, LOCATION_REFRESH_TIME, LOCATION_REFRESH_DISTANCE, this);
        boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if (!isGPSEnabled && !isNetworkEnabled) {
            // no network provider is enabled
            if (viewOk()) {
                mView.get().onNoLocationAvailable();
            }
        } else {
            onLocationChanged(locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER));
        }

    }

    //check against NPE or memory leaks when the view gets destroyed and we don't have the correct refference anymore
    private boolean viewOk() {
        return mView != null && mView.get() != null;
    }

    @Override
    public void onLocationChanged(final Location location) {
        if (location != null && viewOk()) {
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
