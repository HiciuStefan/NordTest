package com.test.forsqtest.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Hiciu on 2/23/2016.
 */
public class RetrofitModelSearch {
    @SerializedName("response")
    public SearchResponse response;

    public class SearchResponse {
        public List<RetrofitModelVenues> getVenues() {
            return venues;
        }

        @SerializedName("venues")
        List<RetrofitModelVenues> venues;
    }
}
