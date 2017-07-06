package com.adhikari.rupak.jimtrace.ui.addexercise;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.adhikari.rupak.jimtrace.R;
import com.adhikari.rupak.jimtrace.models.ExerciseListStructure;
import com.adhikari.rupak.jimtrace.ui.save_record.SaveRecord;

import java.util.List;

/**
 * Created by AM Nepal on 7/5/2017.
 */

public class MainExerciseAdapter extends RecyclerView.Adapter  {

    private Context mContext;
    private List<ExerciseListStructure> records;
    private boolean isClickable;

    public MainExerciseAdapter() {
    }

    public MainExerciseAdapter(Context mContext, List<ExerciseListStructure> records,boolean click) {
        this.mContext = mContext;
        this.records = records;
        this.isClickable = click;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.exercise_list_row_items, parent, false);
        return new Viewholder(v);
    }

    private ExerciseListStructure getitem(int position){
        return records.get(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Viewholder viewholder = (Viewholder) holder;
        viewholder.exercise.setText(getitem(position).getName());
        if(isClickable){
            viewholder.exercise.setClickable(true);
            viewholder.exercise.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(mContext, SaveRecord.class);
                    i.putExtra("name",getitem(position).getName());
                    mContext.startActivity(i);
                }
            });
        }else{
            viewholder.exercise.setClickable(false);
        }
    }

    @Override
    public int getItemCount() {
        return this.records.size();
    }



    class Viewholder extends RecyclerView.ViewHolder{
        TextView exercise;

        public Viewholder(View itemView) {
            super(itemView);
            exercise = (TextView) itemView.findViewById(R.id.exercise_name);
        }
    }
}
