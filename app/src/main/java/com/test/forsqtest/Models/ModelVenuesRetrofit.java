package com.test.forsqtest.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hiciu on 2/24/2016.
 */
public class ModelVenuesRetrofit {
    @SerializedName("name")
    public String name;

    @SerializedName("location")
    public VenuesLocation venuesLocation;

    public class VenuesLocation {
        @SerializedName("address")
        String address;

        public int getDistance() {
            return distance;
        }

        @SerializedName("distance")
        Integer distance;

        public String getAddress() {
            return address;
        }
    }
}
