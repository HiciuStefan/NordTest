package com.test.forsqtest.ViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.test.forsqtest.Models.ModelResultsSearch;
import com.test.forsqtest.R;

import java.util.List;

/**
 * Created by Hiciu on 2/24/2016.
 */
public class SearchListAdapter extends ArrayAdapter<ModelResultsSearch> {
    private final int mLayout;
    private Context mContext;

    public SearchListAdapter(Context context, int resource, List<ModelResultsSearch> items) {
        super(context, resource, items);
        mLayout = resource;
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SearchListViewHolder viewHolder = new SearchListViewHolder();
        View localconvertView = convertView;
        if (localconvertView == null) {
            localconvertView = LayoutInflater.from(mContext).inflate(mLayout, parent, false);
            if (localconvertView != null) {
                viewHolder.name = (TextView) localconvertView.findViewById(R.id.search_results_name);
                viewHolder.address = (TextView) localconvertView.findViewById(R.id.search_results_address);
                viewHolder.distance = (TextView) localconvertView.findViewById(R.id.search_results_distance);
                localconvertView.setTag(viewHolder);
            }
        }else{
            viewHolder = (SearchListViewHolder) localconvertView.getTag();
        }
        ModelResultsSearch item = getItem(position);

        viewHolder.name.setText(item.name);
        viewHolder.address.setText(item.address);
        viewHolder.distance.setText(item.distance);


        return localconvertView;
    }

    private static class SearchListViewHolder {
        public TextView name;
        public TextView address;
        public TextView distance;
    }
}
