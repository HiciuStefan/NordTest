package com.test.forsqtest.Search4Sq;

import com.test.forsqtest.Models.ModelSearchRetrofit;

import junit.framework.TestCase;

/**
 * Created by Hiciu on 2/25/2016.
 */
public class SearchInteractorTest extends TestCase {

    SearchInteractor mInteractor;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mInteractor = new SearchInteractor();
    }

    public void assertTrue(SearchInteractor interactor) throws Exception {
        assertEquals(interactor.checkSetRequirments(), true);
    }

    public void assertFalse(SearchInteractor interactor) throws Exception {
        assertEquals(interactor.checkSetRequirments(), false);
    }

    public void testUpdateLocation() throws Exception {
        SearchInteractor interactor = new SearchInteractor();
        //update location null
        interactor.updateLocation(null);
        assertEquals(interactor.getLocation(), "");
        assertFalse(interactor);
        //update valid location
        interactor.updateLocation("loc");
        assertEquals(interactor.getLocation(), "loc");
        assertFalse(interactor);
        //update query null
        interactor.updateCurrentQuery(null);
        assertFalse(interactor);
        //update query valid
        interactor.updateCurrentQuery("loc");
        assertTrue(interactor);
    }

    public void testUpdateCurrentText() throws Exception {
        SearchInteractor interactor = new SearchInteractor();
        interactor.updateCurrentQuery(null);
        assertEquals(interactor.getCurrentQuerry(), "");
        assertFalse(interactor);
        interactor.updateCurrentQuery("loc");
        assertEquals(interactor.getCurrentQuerry(), "loc");
        assertFalse(interactor);
        interactor.updateLocation(null);
        assertFalse(interactor);
        interactor.updateLocation("loc");
        assertTrue(interactor);

    }

    public void testGetVenues() throws Exception {
        mInteractor.getVenues(null);
    }


    public void testHandleVenuesResponse() throws Exception {
        mInteractor.handleVenuesResponse(null, null);
        mInteractor.handleVenuesResponse(null, new SearchPresenter(null));
        ModelSearchRetrofit model = new ModelSearchRetrofit();
        mInteractor.handleVenuesResponse(model, new SearchPresenter(null));
    }
}