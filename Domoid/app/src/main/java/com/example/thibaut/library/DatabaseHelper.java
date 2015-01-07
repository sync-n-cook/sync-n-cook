package com.example.thibaut.library;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by thibaut on 07/01/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOGIN_TABLE = "CREATE TABLE IF NOT EXISTS " + DatabaseInformations.TABLE_INGREDIENTS + "("
                + DatabaseInformations.KEY_ID + " INTEGER PRIMARY KEY,"
                + DatabaseInformations.KEY_IDCAT + " TEXT,"
                + DatabaseInformations.KEY_NAME + " TEXT, "
                + DatabaseInformations.KEY_QUANTITY + " TEXT,"
                + DatabaseInformations.KEY_DATE + " TEXT)";
    }
}
