package com.adhikari.rupak.jimtrace.dagger.components;

/**
 * Created by AM Nepal on 6/27/2017.
 */


import com.adhikari.rupak.jimtrace.JimTrace;
import com.adhikari.rupak.jimtrace.dagger.modules.ApiModule;
import com.adhikari.rupak.jimtrace.dagger.modules.AppModule;
import com.adhikari.rupak.jimtrace.dagger.modules.NetModule;
import com.adhikari.rupak.jimtrace.networking.ApiInterface;
import com.adhikari.rupak.jimtrace.realm.RealmDatabase;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class, ApiModule.class})
public interface AppComponent{
    ApiInterface apiInterface();
    RealmDatabase database();
    void inject(JimTrace magnify);
}
