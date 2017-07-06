package com.adhikari.rupak.jimtrace.dagger.components;


import com.adhikari.rupak.jimtrace.dagger.modules.ActivityModule;
import com.adhikari.rupak.jimtrace.dagger.modules.RealmModule;
import com.adhikari.rupak.jimtrace.dagger.scopes.PerActivity;
import com.adhikari.rupak.jimtrace.ui.add_record.AddRecord;
import com.adhikari.rupak.jimtrace.ui.addexercise.AddExcersise;
import com.adhikari.rupak.jimtrace.ui.chooser.ChooseActivity;
import com.adhikari.rupak.jimtrace.ui.main_exercise_view.MainActivity;
import com.adhikari.rupak.jimtrace.ui.save_record.SaveRecord;
import com.adhikari.rupak.jimtrace.ui.splash.Splash;

import dagger.Component;

/**
 * Created by AM Nepal on 10/22/2016.
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, RealmModule.class})
public interface ActivityComponent {
    void inject(Splash splash);
    void inject(ChooseActivity chooseActivity);
    void inject(MainActivity mainActivity);
    void inject(AddExcersise addExcersise);
    void inject(AddRecord addRecord);
    void inject(SaveRecord saveRecord);


}

