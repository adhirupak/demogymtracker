package com.adhikari.rupak.jimtrace.dagger.scopes;

/**
 * Created by AM Nepal on 6/27/2017.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity{

}
