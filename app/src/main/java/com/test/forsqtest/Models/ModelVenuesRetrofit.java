package com.test.forsqtest.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hiciu on 2/24/2016.
 */
public class ModelVenuesRetrofit {
    @SerializedName("distance")
    public String distance;

    @SerializedName("name")
    public String name;
    @SerializedName("Location")
    public VenuesLocation venuesLocation;

    public class VenuesLocation {
        @SerializedName("address")
        String address;

        public String getAddress() {
            return address;
        }
    }
}
