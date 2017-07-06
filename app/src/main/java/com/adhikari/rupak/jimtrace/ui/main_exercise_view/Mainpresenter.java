package com.adhikari.rupak.jimtrace.ui.main_exercise_view;

import com.adhikari.rupak.jimtrace.models.Record;
import com.adhikari.rupak.jimtrace.realm.RealmRepository;
import com.adhikari.rupak.jimtrace.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by AM Nepal on 7/5/2017.
 */

public class Mainpresenter extends BasePresenter<MainMvpView> {

    @Inject
    RealmRepository realmRepository;

    @Inject
    public Mainpresenter() {
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void loadDataFromRealm() {
        List<Record> records = realmRepository.getAllData();
        getMvpView().onDataloaded(records);
    }
}
