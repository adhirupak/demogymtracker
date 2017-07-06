package com.adhikari.rupak.jimtrace.ui.save_record;

import com.adhikari.rupak.jimtrace.models.Exercise;
import com.adhikari.rupak.jimtrace.realm.RealmRepository;
import com.adhikari.rupak.jimtrace.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by AM Nepal on 7/6/2017.
 */

public class SavePresenter extends BasePresenter<SaveRecordMvpView> {

    @Inject
    RealmRepository realmRepository;

    @Inject
    public SavePresenter(){}

    @Override
    public void attachView(SaveRecordMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void saveDataToRealm(String exerciseName, String recps, String weights, String date) {
        Exercise ex = new Exercise(exerciseName,recps,weights);
        realmRepository.addToRealm(date,ex);
        getMvpView().loadmainData();

    }
}
