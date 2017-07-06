package com.adhikari.rupak.jimtrace.ui.main_exercise_view;

import com.adhikari.rupak.jimtrace.models.Record;
import com.adhikari.rupak.jimtrace.ui.base.MvpView;

import java.util.List;

/**
 * Created by AM Nepal on 7/5/2017.
 */

public interface MainMvpView extends MvpView {
    void onDataloaded(List<Record> records);
}
