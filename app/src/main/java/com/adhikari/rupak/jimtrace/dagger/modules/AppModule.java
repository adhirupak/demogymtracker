package com.adhikari.rupak.jimtrace.dagger.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.adhikari.rupak.jimtrace.realm.RealmDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by AM Nepal.
 */
@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Singleton
    // Application reference must come from AppModule.class
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    public Context applicationContext() {
        return mApplication.getApplicationContext();
    }

    //because database is needed in application scope
    @Provides
    @Singleton
    RealmDatabase providesRealmDatabase(Context c) {
        return new RealmDatabase(c);
    }

}