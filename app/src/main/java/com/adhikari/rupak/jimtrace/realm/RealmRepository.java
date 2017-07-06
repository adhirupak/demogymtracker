package com.adhikari.rupak.jimtrace.realm;

import android.util.Log;

import com.adhikari.rupak.jimtrace.models.Exercise;
import com.adhikari.rupak.jimtrace.models.ExerciseListStructure;
import com.adhikari.rupak.jimtrace.models.Record;

import java.util.ArrayList;
import java.util.List;

import io.realm.Case;
import io.realm.Realm;

/**
 * Created by Dell on 10/5/2016.
 */
public class RealmRepository {

    RealmDatabase database;
    Realm realm;

    public RealmRepository(RealmDatabase database){
        this.database=database;
        this.realm = database.getRealmInstance();
    }

    public void add(final ExerciseListStructure exercise){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    realm.copyToRealm(exercise);
                    Log.d("DEBUG","added in realm");
                }catch (Exception ex){
                    Log.d("DEBUG",ex.getMessage());
                }
            }
        });
    }

    public List<ExerciseListStructure> getExerciseList() {
       return new ArrayList(realm.where(ExerciseListStructure.class).findAll());
    }

    public List<ExerciseListStructure> getExerciseList(String text) {
        return new ArrayList(realm.where(ExerciseListStructure.class).contains("name",text, Case.INSENSITIVE).findAllSorted("name"));
    }

    public void addToRealm(String date, Exercise ex) {
        Record record = realm.where(Record.class).equalTo("date",date).findFirst();
//        if(record != null){
//            RealmList<Exercise> exercises = record.getExercises();
//            if(exercises == null || exercises.size()<=0){
//              RealmList<Exercise> exex = new RealmList<>();
//              exex.add(ex);
//              record.setExercises(exex);
//              addToRealm(record);
//            }else{
//                RealmList<Exercise> newList = new RealmList<>();
//                for(int i =0;i<exercises.size();i++){
//                    Exercise exer = exercises.get(i);
//                    newList.add(exer);
//                }
//                record.setExercises(newList);
//                addToRealm(record);
//            }
//        }else{
//            RealmList<Exercise> exes = new RealmList<>();
//            exes.add(ex);
//            record = new Record(date,exes);
//            addToRealm(record);
//        }
    }

    private void addToRealm(final Record record) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try{
                    realm.copyToRealmOrUpdate(record);
                }catch (Exception e){
                    Log.d("adding error",e.getMessage());
                }
            }
        });
    }

    public List<Record> getAllData() {
        return new ArrayList(realm.where(Record.class).findAll());
    }

//    public void add(Repository repository){
//        Log.d("DEBUG","add called in realm");
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                // Add a person
//                Repository repo = realm.createObject(Repository.class);
//                repo.setName("Hari");
//                repo.setFullName("Hari Bastola");
//                repo.setDescription("Nepal");
//
//            }
//        });
//    }
//
//
//    public List<Repository> all(){
//        return realm.where(Repository.class).findAll();
//    }
}
