package com.almaron.taxiprinter.Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

public class AutoSuggestAdapter extends ArrayAdapter<String> implements Filterable {

    private List<String> mlistData;

    public AutoSuggestAdapter(Context context, int resource) {
        super(context, resource);
        mlistData = new ArrayList<>();
    }

    public void setData(List<String> list) {
        mlistData.clear();
        mlistData.addAll(list);
    }

    @Override
    public int getCount() {
        return mlistData.size();
    }

    @Override
    public String getItem(int position) {
        return mlistData.get(position);
    }

    public String getObject(int position) {
        return mlistData.get(position);
    }

    @Override
    public Filter getFilter() {
        Filter dataFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    filterResults.values = mlistData;
                    filterResults.count = mlistData.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && (results.count > 0)) {
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };
        return dataFilter;
    }

}
