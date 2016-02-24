package com.test.forsqtest.UI;


import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    @Bind(R.id.text_input_layout)
    TextInputLayout textInputLayout;


    private SearchPresenter presenter;

    public FragmentSearch4Sq() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new SearchPresenter(this);
        //add location listener so we know when the user moved
        new com.test.forsqtest.Search4Sq.LocationListener(getContext(), this);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search4_sq, container, false);
        ButterKnife.bind(this, view);
        textInputLayout.setHint(getString(R.string.hint));
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
        if(getContext() != null) {
            mList.setAdapter(new SearchListAdapter(getContext(), R.layout.list_row_search4sq, list));
        }
    }

    @Override
    public void onNoLocationAvailable() {
        Toast.makeText(getActivity(), getResources().getText(R.string.noLocation), Toast.LENGTH_LONG).show();
    }

}
