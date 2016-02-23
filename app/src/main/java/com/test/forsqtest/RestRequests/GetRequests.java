package com.test.forsqtest.RestRequests;

import com.test.forsqtest.Models.ModelSearchForSq;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;

/**
 * Created by Hiciu on 2/23/2016.
 */
public interface GetRequests {
    @GET("venues/search")
    public Call<ModelSearchForSq> getData(@FieldMap Map<String, String> fields);
}
