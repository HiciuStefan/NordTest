package com.test.forsqtest.Search4Sq;

import android.util.Log;

import com.test.forsqtest.Constants.AppConstants;
import com.test.forsqtest.Models.ModelResultsSearch;
import com.test.forsqtest.Models.ModelSearchRetrofit;
import com.test.forsqtest.Models.ModelVenuesRetrofit;
import com.test.forsqtest.RestRequests.GetRequests;
import com.test.forsqtest.RestRequests.RetrofitAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hiciu on 2/23/2016.
 */
//class that once provided with a search query and a location will be able to return the forsquare venues response as a usable list.
public class SearchInteractor implements ISearchInteractor {
    private static final String TAG_ERROR = "SearchInteractorError";
    private final GetRequests mGetRetrofitAdapter;
    private boolean mSetCurrentLocation, mSetCurrentText;
    private String mCurrentLocation, mCurrentText;

    private static final Integer REQUESTS_LIMIT = 3;

    public SearchInteractor() {
        mSetCurrentLocation = false;
        mSetCurrentText = false;
        mGetRetrofitAdapter = RetrofitAdapter.createService(GetRequests.class);
        mCurrentLocation = "";
        mCurrentText = "";
    }

    //if the user moves , new location means maybe new results
    @Override
    public void updateLocation(String location) {
        if (location == null || location.isEmpty()) {
            Log.d(TAG_ERROR, "updateLocation: Location was null or empty");
            mSetCurrentLocation = false;
            return;
        }
        mCurrentLocation = location;
        mSetCurrentLocation = true;
    }

    //for when the user types a new letter
    @Override
    public void updateCurrentQuery(String text) {
        if (text == null || text.isEmpty()) {
            Log.d(TAG_ERROR, "updateCurrentQuery: Querry was null or empty");
            mSetCurrentText = false;
            return;
        }
        mCurrentText = text;
        mSetCurrentText = true;
    }


    @Override
    public void getVenues(final SearchPresenter searchPresenter) {
        if (searchPresenter == null) {
            Log.d(TAG_ERROR, "getVenues: presenter was null");
            return;
        }
        if (checkSetRequirments()) {
            Map<String, String> params = new HashMap<>();
            params.put("ll", mCurrentLocation);
            params.put("query", mCurrentText);
            params.put("limit", String.valueOf(REQUESTS_LIMIT));
            params.put("client_id", AppConstants.FORSQUARE_CLIENT_ID);
            params.put("client_secret", AppConstants.FORSQUARE_CLIENT_SECRET);
            params.put("v", "20140715");
            mGetRetrofitAdapter.getData(params).enqueue(new Callback<ModelSearchRetrofit>() {
                @Override
                public void onResponse(Call<ModelSearchRetrofit> call, Response<ModelSearchRetrofit> response) {
                    if (response != null && response.isSuccess()) {
                        ModelSearchRetrofit result = response.body();
                        handleVenuesResponse(result, searchPresenter);
                    }
                }

                @Override
                public void onFailure(Call<ModelSearchRetrofit> call, Throwable t) {

                }
            });
        }
    }

    protected void handleVenuesResponse(ModelSearchRetrofit result, SearchPresenter searchPresenter) {
        if (result == null || searchPresenter == null) {
            Log.d(TAG_ERROR, "handleVenuesResponse: response or presenter were null");
            return;
        }
        List<ModelResultsSearch> list = new ArrayList<ModelResultsSearch>();
        if (result != null && result.response != null) {
            //if the response is a success iterate trough all the venues and save the required data into a list
            for (ModelVenuesRetrofit venue :
                    result.response.getVenues()) {
                ModelResultsSearch resultsSearch = new ModelResultsSearch();
                if (venue.venuesLocation != null && venue.venuesLocation.getAddress() != null) {
                    resultsSearch.address = venue.venuesLocation.getAddress();
                    resultsSearch.distance = String.valueOf(venue.venuesLocation.getDistance());
                }

                resultsSearch.name = venue.name;
                list.add(resultsSearch);
            }
        }
        searchPresenter.onGetDataSuccesful(list);
    }

    protected String getLocation() {
        return mCurrentLocation;
    }

    protected String getCurrentQuerry() {
        return mCurrentText;
    }

    protected boolean checkSetRequirments() {
        return mSetCurrentLocation && mSetCurrentText;
    }


}
