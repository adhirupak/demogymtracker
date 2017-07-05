package com.adhikari.rupak.jimtrace.realm;

import android.util.Log;

import com.adhikari.rupak.jimtrace.models.ExerciseListStructure;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

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
