package com.test.forsqtest.Search4Sq;

import java.lang.ref.WeakReference;

/**
 * Created by Hiciu on 2/23/2016.
 */
public class SearchPresenter implements ISearchPresenter {
    private WeakReference<ISearchView> mViewCallbacks;
    private SearchInteractor mInteractor;

    public SearchPresenter(ISearchView view) {
        mViewCallbacks = new WeakReference<ISearchView>(view);
        mInteractor = new SearchInteractor();
    }


    @Override
    public void onLocationUpdate(String location) {
        mInteractor.updateLocation(location);
        mInteractor.getVenues(this);
    }

    @Override
    public void onTextUpdated(String text) {
        mInteractor.updateCurrentText(text);
        mInteractor.getVenues(this);
    }



}
