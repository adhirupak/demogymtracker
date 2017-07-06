package com.adhikari.rupak.jimtrace.ui.main_exercise_view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.adhikari.rupak.jimtrace.R;
import com.adhikari.rupak.jimtrace.models.Record;
import com.adhikari.rupak.jimtrace.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
     Mainpresenter mPresenter;

    @BindView(R.id.recordlist)
    RecyclerView mainRecycleview;

    private MainRecordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getActivityComponent().inject(this);
        mPresenter.attachView(this);
        ButterKnife.bind(this);
        mPresenter.loadDataFromRealm();


    }

    private void setUpData(List<Record> records) {
//        Exercise ex = new Exercise("Chest","4 Stage","20");
//        List<Exercise> exer = new ArrayList<>();
//        for(int i =0;i<9;i++){
//            exer.add(ex);
//        }
//
//        for(int i = 0;i<exer.size();i++){
//            Record r = new Record("july5","friday",exer);
//
//            records.add(r);
//        }

        adapter = new MainRecordAdapter(this,records);
        mainRecycleview.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mainRecycleview.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onDataloaded(List<Record> records) {
        setUpData(records);
    }
}
