package com.example.daria.mythaiapp.server;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import java.util.List;


/**
 * Created by daria on 26.11.16.
 */

public class DatabaseHandlerClass extends SQLiteOpenHelper implements DatabaseHandler {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "myThaiManager";
    private static final String TABLE_DOGS = "dogs";
    private static final String KEY_ID = "id";

    //TODO:нужно будет доделать таблицу и тогда уже прописать методы, я представляю как

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public DatabaseHandlerClass (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void addDog(Dog dog) {

    }

    @Override
    public Dog getDog(int id) {
        return null;
    }

    @Override
    public List<Dog> getAllDogs() {
        return null;
    }

    @Override
    public int updateDog(Dog dog) {
        return 0;
    }

    @Override
    public void deleteDog(Dog dog) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Dog> findbyParametres() {
        return null;
    }
}
