package com.adhikari.rupak.jimtrace.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.adhikari.rupak.jimtrace.R;
import com.adhikari.rupak.jimtrace.ui.base.BaseActivity;
import com.adhikari.rupak.jimtrace.ui.chooser.ChooseActivity;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class Splash extends BaseActivity implements SplashMvpView {

    @Inject
    SplashPresenter mPresenter;
    
    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_splash);
        getActivityComponent().inject(this);
        mPresenter.attachView(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Observable.timer(2000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        //onNewIntent(getIntent());
                         //Toast.makeText(Splash.this, "2ndScreen ", Toast.LENGTH_SHORT).show();
                        loadActivity(ChooseActivity.class);
                    }
                });

    }

    private void loadActivity(Class<ChooseActivity> chooseActivityClass) {
        Intent i = new Intent(this,chooseActivityClass);
        startActivity(i);
        finish();
    }

    /**
     * Checks the intent contains data or not.
     * If intent contains data then starts survey or
     * if intent is empty then loads default 2nd screen.
     * @param intent
     */
    protected void onNewIntent(Intent intent) {
        String action = intent.getAction();
        String data = intent.getDataString();
        if (Intent.ACTION_VIEW.equals(action) && data != null) {
            char character = data.charAt(data.length() -1);
            if(character =='/'){
                id = data.substring(31,data.length()-1);
                Log.d("datatrue",id);

            }else{
                id = data.substring(31);
                Log.d("data",id);
            }
            if(id.contains("/")){
                id = id.substring(1);
            }
         //TODO call survey directly
        }
        else
        {
         //TODO load default second screen
            Toast.makeText(Splash.this, "2ndScreen ", Toast.LENGTH_SHORT).show();
        }
    }


}
