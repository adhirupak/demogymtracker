package com.adhikari.rupak.jimtrace.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by AM Nepal on 7/5/2017.
 */

public class Record  extends RealmObject{
    @PrimaryKey
    private String date;

    private RealmList<Exercise> exercises;

    public Record() {
    }

    public Record(String date, RealmList<Exercise> exercises) {
        this.date = date;
        this.exercises = exercises;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public RealmList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(RealmList<Exercise> exercises) {
        this.exercises = exercises;
    }
}
