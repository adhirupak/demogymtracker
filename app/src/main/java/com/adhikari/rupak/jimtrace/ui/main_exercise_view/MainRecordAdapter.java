package com.adhikari.rupak.jimtrace.ui.main_exercise_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adhikari.rupak.jimtrace.R;
import com.adhikari.rupak.jimtrace.models.Record;
import com.adhikari.rupak.jimtrace.utils.ListViewExpanded;

import java.util.List;

/**
 * Created by AM Nepal on 7/5/2017.
 */

public class MainRecordAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<Record> records;

    public MainRecordAdapter(Context mContext, List<Record> records) {
        this.mContext = mContext;
        this.records = records;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.list_item_record, parent, false);
        return new Viewholder(v);
    }

    private Record getitem(int position){
        return records.get(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Viewholder viewholder = (Viewholder) holder;
        viewholder.dateTextView.setText(getitem(position).getDate());
        ListAdapter adapter = new ListAdapter(mContext,getitem(position).getExercises());
        viewholder.lv.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return this.records.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{
        TextView dateTextView;
        ListViewExpanded lv;

        public Viewholder(View itemView) {
            super(itemView);
            dateTextView = (TextView) itemView.findViewById(R.id.datetext);
            lv = (ListViewExpanded) itemView.findViewById(R.id.desclis);
        }
    }
}
