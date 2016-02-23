package com.test.forsqtest.Search4Sq;

/**
 * Created by Hiciu on 2/23/2016.
 */
public interface ISearchInteractor {

    void updateLocation(String location);

    void updateCurrentText(String text);

    void getVenues(SearchPresenter searchPresenter);
}
