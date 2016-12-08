package com.example.daria.mythaiapp.server;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by daria on 26.11.16.
 */

public class DatabaseHandlerClass extends SQLiteOpenHelper implements DatabaseHandler {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "myThaiManager";

    private static final String TABLE_DOGS = "dogs";
    private static final String KEY_COLUMN_ID_DOG = "id";
    private static final String COLUMN_DATE="date of birth";
    private static final String COLUMN_SEX = "sex";
    private static final String COLUMN_COLOUR="colour";
    private static final String COLUMN_COATTYPE = "coat type";
    private static final String COLUMN_PRICE="date of birth";
    private static final String COLUMN_TEXT="text";


    private static final String TABLE_BREEDERS = "breeders";
    private static final String KEY_COLUMN_ID_BREEDER = "id";
    private static final String COLUMN_NAME="name";

    public DatabaseHandlerClass (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
//TODO разобраться с функциями для двух таблиц в бд
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_DOGS = "CREATE TABLE " + TABLE_DOGS + "("
                + KEY_COLUMN_ID_DOG + " INTEGER PRIMARY KEY," + COLUMN_DATE + " TEXT,"
                + COLUMN_SEX + " INTEGER," + COLUMN_COLOUR + " TEXT,"
                + COLUMN_COATTYPE + " TEXT," + COLUMN_PRICE + " TEXT,"
                + COLUMN_TEXT + " TEXT" + ")";
        db.execSQL(TABLE_DOGS);
/*
        String CREATE_TABLE_BREEDERS = "CREATE TABLE " + TABLE_BREEDERS + "("
                + KEY_COLUMN_ID_BREEDER + " INTEGER PRIMARY KEY," + COLUMN_NAME + " TEXT" + ")";
        db.execSQL(TABLE_BREEDERS);
*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DOGS);
        onCreate(db);
/*
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BREEDERS);
        onCreate(db);
*/
    }

    @Override
    public void addDog(Dog dog) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE, dog.getDate());
        values.put(COLUMN_SEX, dog.isSex());
        values.put(COLUMN_COLOUR, dog.getColour());
        values.put(COLUMN_COATTYPE, dog.getCoatType());
        values.put(COLUMN_PRICE, dog.getCategory());
        values.put(COLUMN_TEXT, dog.getText());
        db.insert(TABLE_DOGS, null, values);
        db.close();

    }

    @Override
    public Dog getDog(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DOGS, new String[] { KEY_COLUMN_ID_DOG,
                        COLUMN_DATE, COLUMN_SEX, COLUMN_COLOUR, COLUMN_COATTYPE,
                        COLUMN_PRICE, COLUMN_TEXT }, KEY_COLUMN_ID_DOG + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        Dog dog = new Dog(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getInt(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
        return dog;
    }

    @Override
    public List<Dog> getAllDogs() {
        List<Dog> dogsList = new ArrayList<Dog>();
        String selectQuery = "SELECT  * FROM " + TABLE_DOGS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Dog dog = new Dog();
                dog.setId(Integer.parseInt(cursor.getString(0)));
                dog.setDate(cursor.getString(1));
                dog.setSex(cursor.getInt(2));
                dog.setColour(cursor.getString(3));
                dog.setCoatType(cursor.getString(4));
                dog.setCategory(cursor.getString(5));
                dog.setText(cursor.getString(6));
                dogsList.add(dog);
            } while (cursor.moveToNext());
        }

        return dogsList;
    }

    @Override
    public int updateDog(Dog dog) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE, dog.getDate());
        values.put(COLUMN_SEX, dog.isSex());
        values.put(COLUMN_COLOUR, dog.getColour());
        values.put(COLUMN_COATTYPE, dog.getCoatType());
        values.put(COLUMN_PRICE, dog.getCategory());
        values.put(COLUMN_TEXT, dog.getText());
        return db.update(TABLE_DOGS, values, KEY_COLUMN_ID_DOG + " = ?",
                new String[] { String.valueOf(dog.getId()) });
    }

    @Override
    public void deleteDog(Dog dog) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DOGS, KEY_COLUMN_ID_DOG + " = ?", new String[] { String.valueOf(dog.getId()) });
        db.close();
    }

    @Override
    public void deleteAllDogs() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DOGS, null, null);
        db.close();
    }


    @Override
    public List<Dog> findbyParametres() {
         /*TODO дописать функцию поиска по параметрам
        List<Dog> dogsList = new ArrayList<Dog>();
        String selectQuery = "SELECT  * FROM " + TABLE_DOGS + "WHERE" + ;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Dog dog = new Dog();
                dog.setId(Integer.parseInt(cursor.getString(0)));
                dog.setDate(cursor.getString(1));
                dog.setSex(cursor.getInt(2));
                dog.setColour(cursor.getString(3));
                dog.setCoatType(cursor.getString(4));
                dog.setCategory(cursor.getString(5));
                dog.setText(cursor.getString(6));
                dogsList.add(dog);
            } while (cursor.moveToNext());
        }
*/
        return null;
    }

    @Override
    public void addBreeder(Breeder breeder) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, breeder.getName());
        db.insert(TABLE_BREEDERS, null, values);
        db.close();
    }

    @Override
    public Breeder getBreeder(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_BREEDERS, new String[] { KEY_COLUMN_ID_BREEDER,
                        COLUMN_NAME }, KEY_COLUMN_ID_BREEDER + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null){
            cursor.moveToFirst();
        }

        Breeder breeder = new Breeder(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
        return breeder;
    }

    @Override
    public List<Breeder> getAllBreeders() {
        List<Breeder> breedersList = new ArrayList<Breeder>();
        String selectQuery = "SELECT  * FROM " + TABLE_BREEDERS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Breeder breeder = new Breeder();
                breeder.setId(Integer.parseInt(cursor.getString(0)));
                breeder.setName(cursor.getString(1));
                breedersList.add(breeder);
            } while (cursor.moveToNext());
        }

        return breedersList;
    }

    @Override
    public int updateBreeder(Breeder breeder) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, breeder.getName());
        return db.update(TABLE_BREEDERS, values, KEY_COLUMN_ID_BREEDER + " = ?",
                new String[] { String.valueOf(breeder.getId()) });
    }

    @Override
    public void deleteBreeder(Breeder breeder) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BREEDERS, KEY_COLUMN_ID_BREEDER + " = ?", new String[] { String.valueOf(breeder.getId()) });
        db.close();
    }

    @Override
    public void deleteAllBreeders() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BREEDERS, null, null);
        db.close();
    }



}
