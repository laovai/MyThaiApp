package com.example.daria.mythaiapp.server;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;


/**
 * Created by daria on 26.11.16.
 */

public class DatabaseHandlerClass extends SQLiteOpenHelper implements DatabaseHandler {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mythaiManager";
    private static final String TABLE_DOGS = "dogs";
    private static final String KEY_ID = "id";
    //TODO:доделать таблицу

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public DatabaseHandlerClass (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /*@Override
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

    }*/
}
