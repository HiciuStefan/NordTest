package com.test.forsqtest.Search4Sq;

import android.location.Location;

import com.test.forsqtest.Models.ModelResultsSearch;

import java.util.List;

/**
 * Created by Hiciu on 2/23/2016.
 */
public interface ISearchView {

    void onLocationUpdated(Location newLocation);
    void onReceivedNewData(List<ModelResultsSearch> list);
}
