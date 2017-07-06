package com.adhikari.rupak.jimtrace.ui.addexercise;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.widget.EditText;

import com.adhikari.rupak.jimtrace.R;
import com.adhikari.rupak.jimtrace.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddExcersise extends BaseActivity implements AddExerciseMvpView {
    @Inject
    AddExPresenter mPresenter;
    private String m_Text;

    @BindView(R.id.listexercise)
    RecyclerView mainRecycleview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_excersise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getActivityComponent().inject(this);
        mPresenter.attachView(this);
        ButterKnife.bind(this);
        setUpList();

    }

    private void setUpList() {
        MainExerciseAdapter adapter = new MainExerciseAdapter(this,mPresenter.getList(),false);
        mainRecycleview.setLayoutManager(new LinearLayoutManager(this));
        mainRecycleview.setAdapter(adapter);
    }

    @OnClick(R.id.fab)
    public void onfabClick(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add Exercise");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_Text = input.getText().toString();
                mPresenter.addDataToRealm(m_Text);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    @Override
    public void resetList() {
        setUpList();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
