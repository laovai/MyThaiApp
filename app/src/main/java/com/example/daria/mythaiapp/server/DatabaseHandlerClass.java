package com.example.daria.mythaiapp.server;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;

import java.util.List;


/**
 * Created by daria on 26.11.16.
 */

public class DatabaseHandlerClass extends SQLiteOpenHelper implements DatabaseHandler {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "myThaiManager";
    private static final String TABLE_DOGS = "dogs";
    private static final String KEY_COLUMN_ID = "id";
    private static final String COLUMN_DATE="date of birth";
    private static final String COLUMN_SEX = "sex";
    private static final String COLUMN_COLOUR="colour";
    private static final String COLUMN_COATTYPE = "coat type";
    private static final String COLUMN_PRICE="date of birth";
    private static final String COLUMN_TEXT="text";

    public DatabaseHandlerClass (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_DOGS = "CREATE TABLE " + TABLE_DOGS + "("
                + KEY_COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_DATE+ " TEXT,"
                + COLUMN_SEX + " INTEGER," + COLUMN_COLOUR + " TEXT,"
                + COLUMN_COATTYPE + " TEXT," + COLUMN_PRICE + " TEXT,"
                + COLUMN_TEXT + " TEXT" + ")";
        db.execSQL(TABLE_DOGS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DOGS);
        onCreate(db);
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

        Cursor cursor = db.query(TABLE_DOGS, new String[] { KEY_COLUMN_ID,
                        COLUMN_DATE, COLUMN_SEX, COLUMN_COLOUR, COLUMN_COATTYPE,
                        COLUMN_PRICE, COLUMN_TEXT }, KEY_COLUMN_ID + "=?",
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
