package com.test.forsqtest.Search4Sq;

import android.test.AndroidTestCase;


/**
 * Created by Hiciu on 2/24/2016.
 */
public class LocationListenerTest extends AndroidTestCase {
    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testInitializeNull() throws Exception {
        LocationListener locationListener = new LocationListener(null, null);
    }
}