package com.test.forsqtest.Search4Sq;

/**
 * Created by Hiciu on 2/23/2016.
 */
public interface ISearchPresenter {

    void onLocationUpdate(String location);
    void onTextUpdated(String text);
    void onGetDataSuccesful();
}
