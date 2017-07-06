package com.adhikari.rupak.jimtrace.ui.add_record;

import com.adhikari.rupak.jimtrace.models.ExerciseListStructure;
import com.adhikari.rupak.jimtrace.realm.RealmRepository;
import com.adhikari.rupak.jimtrace.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by AM Nepal on 7/6/2017.
 */

public class AddRecordPresenter extends BasePresenter<AddRecordMvpView> {

    @Inject
    RealmRepository realmRepository;

    @Inject
    public AddRecordPresenter() {
    }

    @Override
    public void attachView(AddRecordMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public List<ExerciseListStructure> getList() {
        return realmRepository.getExerciseList();

    }

    public List<ExerciseListStructure> getList(String text) {
        return realmRepository.getExerciseList(text);

    }
}
