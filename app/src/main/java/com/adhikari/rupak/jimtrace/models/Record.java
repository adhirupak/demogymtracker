package com.adhikari.rupak.jimtrace.models;

import java.util.List;

/**
 * Created by AM Nepal on 7/5/2017.
 */

public class Record {
    private String date;
    private String day;
    private List<Exercise> exercises;

    public Record(String date, String day, List<Exercise> exercises) {
        this.date = date;
        this.day = day;
        this.exercises = exercises;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
