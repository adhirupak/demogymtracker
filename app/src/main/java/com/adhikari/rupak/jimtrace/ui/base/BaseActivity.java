package com.adhikari.rupak.jimtrace.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.adhikari.rupak.jimtrace.dagger.Injector;
import com.adhikari.rupak.jimtrace.dagger.components.ActivityComponent;


/**
 * Created by Dell on 10/18/2016.
 */
public class BaseActivity extends AppCompatActivity {

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.initialiseActivityComponent(this);
    }


    public ActivityComponent getActivityComponent(){
        return Injector.getActivityComponent();
    }

}
