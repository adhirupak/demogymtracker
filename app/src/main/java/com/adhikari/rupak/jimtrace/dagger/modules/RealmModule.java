package com.adhikari.rupak.jimtrace.dagger.modules;


import com.adhikari.rupak.jimtrace.dagger.scopes.PerActivity;
import com.adhikari.rupak.jimtrace.realm.RealmDatabase;
import com.adhikari.rupak.jimtrace.realm.RealmRepository;

import dagger.Module;
import dagger.Provides;


/**
 * Created by AM Nepal.
 */

@Module
public class RealmModule {

    @Provides
    @PerActivity
    RealmRepository providesRealmRepository(RealmDatabase database) {
        return new RealmRepository(database);
    }
}
