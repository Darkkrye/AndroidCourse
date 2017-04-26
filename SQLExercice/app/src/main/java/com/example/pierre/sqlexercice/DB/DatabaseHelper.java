package com.example.pierre.sqlexercice.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pierre.sqlexercice.DB.DAO.AuthorDAO;
import com.example.pierre.sqlexercice.DB.DAO.PostDAO;

/**
 * Created by vathenbala on 10/04/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "my_sqlite.db";
    private static final int DATABASE_VERSION = 1;

    private static DatabaseHelper sharedInstance;

    public static synchronized DatabaseHelper getSharedInstance(Context context) {
        if (sharedInstance == null) {
            sharedInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sharedInstance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PostDAO.CREATE_TABLE);
        db.execSQL(AuthorDAO.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // The simple way to manage db version change is to drop everything
            // But you should think about your existing data
            db.execSQL("DROP TABLE IF EXISTS " + PostDAO.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + AuthorDAO.TABLE_NAME);
            onCreate(db);
        }
    }
}
