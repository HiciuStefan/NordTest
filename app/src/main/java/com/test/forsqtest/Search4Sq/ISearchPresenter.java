package com.test.forsqtest.Search4Sq;

import com.test.forsqtest.Models.ModelResultsSearch;

import java.util.List;

/**
 * Created by Hiciu on 2/23/2016.
 */
public interface ISearchPresenter {

    void onLocationUpdate(String location);
    void onTextUpdated(String text);
    void onGetDataSuccesful(List<ModelResultsSearch> list);
}
