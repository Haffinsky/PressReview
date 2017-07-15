package com.example.rafal.pressreview.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rafal on 4/5/2017.
 */

public class NewsDatabaseHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "news.db";
    static final int DATABASE_VERSION = 1;
    //tables in the DB

    static final String TABLE_NAME = "news";
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String ARTICLE_URL = "articleUrl";
    public static final String IMAGE_URL = "imageUrl";

    static final String PROVIDER_TABLE_NAME = "providers";
    public static final String PROVIDER_ID = "provider_id";
    public static final String PROVIDER_NAME = "provider_name";
    public static final String PROVIDER_DESCRIPTION = "provider_description";
    public static final String PROVIDER_LANGUAGE = "provider_language";
    public static final String PROVIDER_CATEGORY = "provider_category";

    static final String PROVIDER_NEWS_TABLE_NAME = "providerNews";
    public static final String PROVIDER_NEWS_TITLE = "title";
    public static final String PROVIDER_ARTICLE_URL = "articleUrl";
    public static final String PROVIDER_IMAGE_URL = "imageUrl";


    String SQL_CREATE_NEWS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
            ID + " INTEGER PRIMARY KEY, " +
            TITLE + " TEXT NOT NULL, " +
            DESCRIPTION + " TEXT NOT NULL, " +
            ARTICLE_URL + " TEXT NOT NULL, " +
            IMAGE_URL + " TEXT NOT NULL " +
            " );";

    String SQL_DROP_NEWS_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;


    String SQL_CREATE_PROVIDER_TABLE = "CREATE TABLE IF NOT EXISTS " + PROVIDER_TABLE_NAME + " (" +
            ID + " INTEGER PRIMARY KEY, " +
            PROVIDER_ID + " TEXT NOT NULL, " +
            PROVIDER_NAME + " TEXT NOT NULL, " +
            PROVIDER_DESCRIPTION + " TEXT NOT NULL, " +
            PROVIDER_LANGUAGE + " TEXT NOT NULL, " +
            PROVIDER_CATEGORY + " TEXT NOT NULL " +
            " );";


    String SQL_DROP_PROVIDER_TABLE = "DROP TABLE IF EXISTS " + PROVIDER_TABLE_NAME;

    String SQL_CREATE_PROVIDER_NEWS_TABLE = "CREATE TABLE IF NOT EXISTS " + PROVIDER_NEWS_TABLE_NAME + " (" +
            ID + " INTEGER PRIMARY KEY, " +
            PROVIDER_NEWS_TITLE + " TEXT NOT NULL, " +
            PROVIDER_ARTICLE_URL + " TEXT NOT NULL, " +
            PROVIDER_IMAGE_URL + " TEXT NOT NULL " +
            " );";

    String SQL_DROP_PROVIDER_NEWS_TABLE = "DROP TABLE IF EXISTS " + PROVIDER_NEWS_TABLE_NAME;

    public NewsDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_NEWS_TABLE);
        db.execSQL(SQL_CREATE_PROVIDER_TABLE);
        db.execSQL(SQL_CREATE_PROVIDER_NEWS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_NEWS_TABLE);
        db.execSQL(SQL_DROP_PROVIDER_TABLE);
        db.execSQL(SQL_DROP_PROVIDER_NEWS_TABLE);
        onCreate(db);
    }

    //method that empties the content of SQLite db
    public void dropAndRecreateNewsTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(SQL_DROP_NEWS_TABLE);
        db.execSQL(SQL_CREATE_NEWS_TABLE);
    }

    public void dropAndRecreateProviderTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(SQL_DROP_PROVIDER_TABLE);
        db.execSQL(SQL_CREATE_PROVIDER_TABLE);
    }
    public void dropAndRecreateProviderNewsTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(SQL_DROP_PROVIDER_NEWS_TABLE);
        db.execSQL(SQL_CREATE_PROVIDER_NEWS_TABLE);
    }
}
