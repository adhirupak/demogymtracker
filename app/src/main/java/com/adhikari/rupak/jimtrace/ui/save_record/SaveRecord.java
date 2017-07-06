package com.adhikari.rupak.jimtrace.ui.save_record;


import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

import com.adhikari.rupak.jimtrace.R;
import com.adhikari.rupak.jimtrace.ui.base.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SaveRecord extends BaseActivity implements SaveRecordMvpView {

    @Inject
    SavePresenter mPresenter;
    private String exerciseName;

    @BindView(R.id.exercise_name)
    AppCompatTextView nameView;

    @BindView(R.id.recps)
    EditText recpsEditText;

    @BindView(R.id.weights)
    EditText wieghtEdittext;

    @BindView(R.id.button_save)
    Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_record);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getActivityComponent().inject(this);
        mPresenter.attachView(this);
        ButterKnife.bind(this);
        exerciseName = getIntent().getExtras().getString("name");
        nameView.setText(exerciseName);
    }

    @OnClick(R.id.button_save)
    public void onSave(){
        String recps = recpsEditText.getText().toString().trim();
        String weights = wieghtEdittext.getText().toString().trim();
        String date = generateDate();
        mPresenter.saveDataToRealm(exerciseName,recps,weights,date);
    }

    private String generateDate() {
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());
        return formattedDate;

    }

    @Override
    public void loadmainData() {
        this.finish();
    }
}
