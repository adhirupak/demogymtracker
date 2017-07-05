package com.adhikari.rupak.jimtrace.models;

import io.realm.RealmObject;

/**
 * Created by AM Nepal on 7/5/2017.
 */

public class ExerciseListStructure extends RealmObject {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
