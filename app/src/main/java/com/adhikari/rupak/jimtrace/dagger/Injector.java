package com.adhikari.rupak.jimtrace.dagger;

import com.adhikari.rupak.jimtrace.JimTrace;
import com.adhikari.rupak.jimtrace.dagger.components.ActivityComponent;
import com.adhikari.rupak.jimtrace.dagger.components.AppComponent;
import com.adhikari.rupak.jimtrace.dagger.components.DaggerActivityComponent;
import com.adhikari.rupak.jimtrace.dagger.components.DaggerAppComponent;
import com.adhikari.rupak.jimtrace.dagger.modules.ActivityModule;
import com.adhikari.rupak.jimtrace.dagger.modules.ApiModule;
import com.adhikari.rupak.jimtrace.dagger.modules.AppModule;
import com.adhikari.rupak.jimtrace.dagger.modules.NetModule;
import com.adhikari.rupak.jimtrace.dagger.modules.RealmModule;
import com.adhikari.rupak.jimtrace.ui.base.BaseActivity;

/**
 * Created by AM Nepal on 6/27/2017.
 */

public class Injector {
    private static AppComponent mAppComponent;
    private static ActivityComponent mActivityComponent;


    private Injector() {}

    public static void initializeApplicationComponent(JimTrace application) {
        mAppComponent = DaggerAppComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(application))
                .netModule(new NetModule(application, "urlhere"))
                .apiModule(new ApiModule())
                .build();
    }

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static void initialiseActivityComponent(BaseActivity activity) {
        mActivityComponent = DaggerActivityComponent.builder()
                .appComponent(getAppComponent())
                // list of modules that are part of this component need to be created here too
                .activityModule(new ActivityModule(activity))
                .realmModule(new RealmModule())
                .build();
    }

    public static ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }
}
