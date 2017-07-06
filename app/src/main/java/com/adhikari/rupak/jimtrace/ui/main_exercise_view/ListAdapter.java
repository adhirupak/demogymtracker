package com.adhikari.rupak.jimtrace.ui.main_exercise_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.adhikari.rupak.jimtrace.R;
import com.adhikari.rupak.jimtrace.models.Exercise;

import java.util.List;

/**
 * Created by AM Nepal on 7/5/2017.
 */

public class ListAdapter extends BaseAdapter {

    private List<Exercise> exercises;
    private Context mContext;

    public ListAdapter() {
    }

    public ListAdapter(Context c, List<Exercise> exercises) {
        this.exercises = exercises;
        this.mContext = c;
    }

    @Override
    public int getCount() {
        return this.exercises.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(R.layout.row_list_item_detail, null);
        }

        Exercise p = (Exercise) getItem(position);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.name);
            TextView tt2 = (TextView) v.findViewById(R.id.steps);
            TextView tt3 = (TextView) v.findViewById(R.id.weights);
        }

        return v;
    }

}