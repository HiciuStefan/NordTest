package com.test.forsqtest.UI;


import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.test.forsqtest.Models.ModelResultsSearch;
import com.test.forsqtest.R;
import com.test.forsqtest.Search4Sq.ISearchView;
import com.test.forsqtest.Search4Sq.SearchPresenter;
import com.test.forsqtest.ViewAdapters.SearchListAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSearch4Sq extends Fragment implements ISearchView {

    @Bind(R.id.edit_text)
    public TextView mTextInput;
    @Bind(R.id.list_search_results)
    public ListView mList;


    private SearchPresenter presenter;

    public FragmentSearch4Sq() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new SearchPresenter(this);
        LocationListener locationListener = new com.test.forsqtest.Search4Sq.LocationListener(getActivity(), this);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search4_sq, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnTextChanged(R.id.edit_text)
    void onTextChanged(CharSequence text) {
        presenter.onTextUpdated(text.toString());
    }

    @Override
    public void onLocationUpdated(Location location) {
        presenter.onLocationUpdate(String.valueOf(location.getLatitude()) + "," + String.valueOf(location.getLongitude()));
    }

    @Override
    public void onReceivedNewData(List<ModelResultsSearch> list) {
        mList.setAdapter(new SearchListAdapter(getActivity(), R.layout.list_row_search4sq, list));

    }

}
