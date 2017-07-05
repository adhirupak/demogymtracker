package com.adhikari.rupak.jimtrace.models;

import io.realm.RealmObject;

/**
 * Created by AM Nepal on 7/5/2017.
 */

public class Exercise extends RealmObject {
    private String name;
    private String steps;
    private String weight;

    public Exercise(String name, String steps, String weight) {
        this.name = name;
        this.steps = steps;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
