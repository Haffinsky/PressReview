package com.example.rafal.pressreview.Data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Rafal on 4/5/2017.
 */

public class NewsContentProvider extends ContentProvider {

    public static final String CONTENT_AUTHORITY = "rafal.pressreview";
    private NewsDatabaseHelper newsDatabaseHelper;
    public static final String PATH_NEWS = "news";
    public static final int NEWS = 100;
    public static final int NEWS_ID = 101;
    private static final UriMatcher uriMatcher = buildUriMatcher();

    public static UriMatcher buildUriMatcher(){

        UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(CONTENT_AUTHORITY, PATH_NEWS, NEWS);
        matcher.addURI(CONTENT_AUTHORITY, PATH_NEWS + "/#", NEWS_ID);

        return matcher;
    }

    @Override
    public boolean onCreate() {
        newsDatabaseHelper = new NewsDatabaseHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(NewsDatabaseHelper.TABLE_NAME);

        int uriType = uriMatcher.match(uri);
        switch (uriType){
            case NEWS:
                break;
            case NEWS_ID:
                queryBuilder.appendWhere(NewsDatabaseHelper.ID + "=" + uri.getLastPathSegment());
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        SQLiteDatabase db = newsDatabaseHelper.getWritableDatabase();
        Cursor cursor = queryBuilder.query(db, projection, selection,
                selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        int uriType = uriMatcher.match(uri);
        SQLiteDatabase db = newsDatabaseHelper.getWritableDatabase();
        long id = 0;
        switch (uriType){
            case NEWS:
                id = db.insert(NewsDatabaseHelper.TABLE_NAME, null, values);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse(PATH_NEWS + "/" + id);
    }


    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
