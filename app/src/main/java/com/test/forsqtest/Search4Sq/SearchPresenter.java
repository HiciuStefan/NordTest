package com.test.forsqtest.Search4Sq;

import com.test.forsqtest.Models.ModelResultsSearch;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by Hiciu on 2/23/2016.
 */
public class SearchPresenter implements ISearchPresenter {
    private WeakReference<ISearchView> mViewReference;
    private SearchInteractor mInteractor;

    public SearchPresenter(ISearchView view) {
        mViewReference = new WeakReference<ISearchView>(view);
        mInteractor = new SearchInteractor();
    }

    // if we get a new location we must notify our interactor to update his location too
    @Override
    public void onLocationUpdate(String location) {
        mInteractor.updateLocation(location);
        mInteractor.getVenues(this);
    }

    // if the user updates his querry the interactor must know too
    @Override
    public void onTextUpdated(String text) {
        mInteractor.updateCurrentText(text);
        mInteractor.getVenues(this);
    }

    //when the interactor succesfully retrieves data , our view must show it.
    @Override
    public void onGetDataSuccesful(List<ModelResultsSearch> list) {
        ISearchView view = mViewReference.get();
        if (view != null) {
            view.onReceivedNewData(list);
        }
    }

}
