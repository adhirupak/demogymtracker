package com.adhikari.rupak.jimtrace.ui.chooser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.adhikari.rupak.jimtrace.R;
import com.adhikari.rupak.jimtrace.ui.add_record.AddRecord;
import com.adhikari.rupak.jimtrace.ui.addexercise.AddExcersise;
import com.adhikari.rupak.jimtrace.ui.base.BaseActivity;
import com.adhikari.rupak.jimtrace.ui.main_exercise_view.MainActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseActivity extends BaseActivity implements ChooseMvpView {

    @Inject
    ChoosePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getActivityComponent().inject(this);
        mPresenter.attachView(this);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.viewrec,R.id.add,R.id.viewexe})
    public void onButtonClick(View v){
        Intent i = null;
        switch (v.getId()){
            case R.id.viewrec:
                i = new Intent(this, MainActivity.class);
                break;
            case R.id.viewexe:
                i = new Intent(this, AddExcersise.class);
                break;
            case R.id.add:
                i = new Intent(this, AddRecord.class);
                break;

        }
        if(i != null){
            startActivity(i);
        }
    }

}
