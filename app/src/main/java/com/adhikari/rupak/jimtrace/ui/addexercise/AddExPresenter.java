package com.adhikari.rupak.jimtrace.ui.addexercise;

import com.adhikari.rupak.jimtrace.models.ExerciseListStructure;
import com.adhikari.rupak.jimtrace.realm.RealmRepository;
import com.adhikari.rupak.jimtrace.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by AM Nepal on 7/5/2017.
 */

public class AddExPresenter extends BasePresenter<AddExerciseMvpView> {

    @Inject
    RealmRepository realmRepository;

    @Inject
    public AddExPresenter() {}

    @Override
    public void attachView(AddExerciseMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void addDataToRealm(String data){
        ExerciseListStructure exSt = new ExerciseListStructure();
        exSt.setName(data);
        realmRepository.add(exSt);
    }
}
