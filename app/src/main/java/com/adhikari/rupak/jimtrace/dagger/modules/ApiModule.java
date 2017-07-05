package com.adhikari.rupak.jimtrace.dagger.modules;


import com.adhikari.rupak.jimtrace.networking.ApiInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by AM NEPAL.
 */
@Module
public class ApiModule {
    @Provides
    @Singleton
    public ApiInterface providesApiInterface(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }
}