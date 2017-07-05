package com.adhikari.rupak.jimtrace;

import android.app.Application;

import com.adhikari.rupak.jimtrace.dagger.Injector;
import com.adhikari.rupak.jimtrace.realm.RealmDatabase;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import javax.inject.Inject;

/**
 * Created by AM Nepal on 7/5/2017.
 */

public class JimTrace extends Application {
    @Inject
    RealmDatabase database;

    @Override
    public void onCreate(){
        super.onCreate();
        Injector.initializeApplicationComponent(this);
        Injector.getAppComponent().inject(this);
        database.setup();
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                .build());

    }
}
