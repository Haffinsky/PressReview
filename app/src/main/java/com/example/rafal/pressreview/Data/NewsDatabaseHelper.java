package com.example.rafal.pressreview.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rafal on 4/5/2017.
 */

public class NewsDatabaseHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "news.db";
    static final String TABLE_NAME = "news";
    static final int DATABASE_VERSION = 1;
    //tables in the DB
    static final String ID = "id";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String ARTICLE_URL = "articleUrl";
    public static final String IMAGE_URL = "imageUrl";


    String SQL_CREATE_NEWS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
            ID + " INTEGER PRIMARY KEY, " +
            TITLE + " TEXT UNIQUE, " +
            DESCRIPTION + " TEXT NOT NULL, " +
            ARTICLE_URL + " TEXT NOT NULL, " +
            IMAGE_URL + " TEXT NOT NULL " +
            " );";

    String SQL_DROP_NEWS_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public NewsDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_NEWS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_NEWS_TABLE);
        onCreate(db);
    }

    //method that empties the content of SQLite db
    public void dropAndRecreateDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(SQL_DROP_NEWS_TABLE);
        db.execSQL(SQL_CREATE_NEWS_TABLE);
    }

    public void dropDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(SQL_DROP_NEWS_TABLE);
    }
}
