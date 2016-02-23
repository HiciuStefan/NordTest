package com.test.forsqtest.Search4Sq;

import com.test.forsqtest.Models.ModelSearchForSq;
import com.test.forsqtest.RestRequests.GetRequests;
import com.test.forsqtest.RestRequests.RetrofitAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hiciu on 2/23/2016.
 */
public class SearchInteractor implements ISearchInteractor {
    private final GetRequests mGetRetrofitAdapter;
    private boolean mCurrentLocationSet, mCurrentTextSet;
    String mCurrentLocation, mCurrentText;

    public SearchInteractor() {
        mCurrentLocationSet = false;
        mCurrentTextSet = false;
        mGetRetrofitAdapter = RetrofitAdapter.createService(GetRequests.class);
    }

    @Override
    public void updateLocation(String location) {
        if (location == null || location.isEmpty()) {
            mCurrentLocationSet = false;
            return;
        }
        mCurrentLocation = location;
    }


    @Override
    public void updateCurrentText(String text) {
        if (text == null || text.isEmpty()) {
            mCurrentTextSet = false;
            return;
        }
        mCurrentText = text;
    }

    @Override
    public void getVenues(SearchPresenter searchPresenter) {


        mGetRetrofitAdapter.getData().enqueue(new Callback<ModelSearchForSq>(){

            @Override
            public void onResponse(Call<ModelSearchForSq> call, Response<ModelSearchForSq> response) {

            }

            @Override
            public void onFailure(Call<ModelSearchForSq> call, Throwable t) {

            }
        });
    }


}
