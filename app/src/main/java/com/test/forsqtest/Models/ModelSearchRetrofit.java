package com.test.forsqtest.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Hiciu on 2/23/2016.
 */
public class ModelSearchRetrofit {
    @SerializedName("response")
    public SearchResponse response;

    public class SearchResponse {
        public List<ModelVenuesRetrofit> getVenues() {
            return venues;
        }

        public void setVenues(List<ModelVenuesRetrofit> venues) {
            this.venues = venues;
        }

        @SerializedName("venues")
        List<ModelVenuesRetrofit> venues;
    }
}
