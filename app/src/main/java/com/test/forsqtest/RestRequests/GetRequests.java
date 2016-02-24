package com.test.forsqtest.RestRequests;

import com.test.forsqtest.Models.RetrofitModelSearch;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Hiciu on 2/23/2016.
 */
public interface GetRequests {
    @GET("venues/search")
    public Call<RetrofitModelSearch> getData(@QueryMap  Map<String, String>fields);
}
