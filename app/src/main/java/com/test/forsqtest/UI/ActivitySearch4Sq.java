package com.test.forsqtest.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.test.forsqtest.R;

public class ActivitySearch4Sq extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_location);
        if (savedInstanceState == null) {
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = new FragmentSearch4Sq();
            fm.beginTransaction()
                    .replace(R.id.main_container, fragment, FragmentSearch4Sq.class.getCanonicalName())
                    .commit();
        }
    }
}
