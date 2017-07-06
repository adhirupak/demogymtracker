package com.adhikari.rupak.jimtrace.ui.add_record;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.adhikari.rupak.jimtrace.R;
import com.adhikari.rupak.jimtrace.models.ExerciseListStructure;
import com.adhikari.rupak.jimtrace.ui.addexercise.MainExerciseAdapter;
import com.adhikari.rupak.jimtrace.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddRecord extends BaseActivity implements AddRecordMvpView, SearchView.OnQueryTextListener {

    @Inject
    AddRecordPresenter mPresenter;

    @BindView(R.id.exerciselist)
    RecyclerView mainRecycleview;

    @BindView(R.id.nodata)
    TextView noDataInfo;

    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getActivityComponent().inject(this);
        mPresenter.attachView(this);
        ButterKnife.bind(this);
        searchView = (SearchView) findViewById(R.id.search);
        searchView.setOnQueryTextListener(this);
        setUpList(mPresenter.getList());


    }
    private void setUpList(List<ExerciseListStructure> exerciseListStructures) {
        List<ExerciseListStructure> ex = exerciseListStructures;
        if(ex == null || ex.size() <=0){
            mainRecycleview.setVisibility(View.GONE);
            noDataInfo.setVisibility(View.VISIBLE);
        }else{
            mainRecycleview.setVisibility(View.VISIBLE);
            noDataInfo.setVisibility(View.GONE);
            MainExerciseAdapter adapter = new MainExerciseAdapter(this,ex,true);
            mainRecycleview.setLayoutManager(new LinearLayoutManager(this));
            mainRecycleview.setAdapter(adapter);
        }

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if(newText.length()>0) {
            setUpList(mPresenter.getList(newText));
        }else
        {
            setUpList(mPresenter.getList());
        }
        return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
