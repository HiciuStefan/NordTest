package com.test.forsqtest.Search4Sq;

import junit.framework.TestCase;

/**
 * Created by Hiciu on 2/25/2016.
 */
public class SearchPresenterTest extends TestCase {

    public void testOnLocationUpdate() throws Exception {
        SearchPresenter pr = new SearchPresenter(null);
        pr.onLocationUpdate(null);
    }

    public void testOnTextUpdated() throws Exception {
        SearchPresenter pr = new SearchPresenter(null);
        pr.onTextUpdated(null);
    }

    public void testOnGetDataSuccesful() throws Exception {
        SearchPresenter pr = new SearchPresenter(null);
        pr.onGetDataSuccesful(null);
    }
}