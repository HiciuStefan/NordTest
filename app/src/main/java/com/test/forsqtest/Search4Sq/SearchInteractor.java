package com.test.forsqtest.Search4Sq;

import com.test.forsqtest.Constants.AppConstants;
import com.test.forsqtest.Models.ModelSearchRetrofit;
import com.test.forsqtest.Models.ModelVenuesRetrofit;
import com.test.forsqtest.RestRequests.GetRequests;
import com.test.forsqtest.RestRequests.RetrofitAdapter;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hiciu on 2/23/2016.
 */
public class SearchInteractor implements ISearchInteractor {
    private final GetRequests mGetRetrofitAdapter;
    private boolean mSetCurrentLocation, mSetCurrentText;
    String mCurrentLocation, mCurrentText;

    public SearchInteractor() {
        mSetCurrentLocation = false;
        mSetCurrentText = false;
        mGetRetrofitAdapter = RetrofitAdapter.createService(GetRequests.class);
    }

    @Override
    public void updateLocation(String location) {
        if (location == null || location.isEmpty()) {
            mSetCurrentLocation = false;
            return;
        }
        mCurrentLocation = location;
        mSetCurrentLocation = true;
    }


    @Override
    public void updateCurrentText(String text) {
        if (text == null || text.isEmpty()) {
            mSetCurrentText = false;
            return;
        }
        mCurrentText = text;
        mSetCurrentText = true;
    }

    @Override
    public void getVenues(SearchPresenter searchPresenter) {

        if (mSetCurrentLocation && mSetCurrentText) {

            Map<String, String> params = new HashMap<>();
            params.put("ll", mCurrentLocation);
            params.put("query", mCurrentText);
            params.put("limit", "3");
            params.put("client_id", AppConstants.FORSQUARE_CLIENT_ID);
            params.put("client_secret", AppConstants.FORSQUARE_CLIENT_SECRET);
            params.put("v", "20140715");
            mGetRetrofitAdapter.getData(params).enqueue(new Callback<ModelSearchRetrofit>() {
                @Override
                public void onResponse(Call<ModelSearchRetrofit> call, Response<ModelSearchRetrofit> response) {
                    ModelSearchRetrofit result = response.body();
                    if (response.isSuccess() && result != null && result.response != null) {

                        for (ModelVenuesRetrofit venue :
                                result.response.getVenues()) {

                        }
                    }
                }

                @Override
                public void onFailure(Call<ModelSearchRetrofit> call, Throwable t) {

                }
            });
        }
    }


}
