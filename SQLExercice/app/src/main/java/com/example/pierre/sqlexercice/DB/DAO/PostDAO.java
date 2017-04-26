package com.example.pierre.sqlexercice.DB.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.pierre.sqlexercice.DB.DatabaseHelper;
import com.example.pierre.sqlexercice.Model.Post;

/**
 * Created by vathenbala on 10/04/2017.
 */

public class PostDAO {

    public static final String TABLE_NAME = "post";

    // Columns
    private static final String KEY_POST_ID = "id";
    private static final String KEY_POST_TEXT = "text";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            "(" +
            KEY_POST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            KEY_POST_TEXT + " TEXT" +
            ")";

    public static void insert(Context context, Post post) {
        DatabaseHelper helper = DatabaseHelper.getSharedInstance(context.getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_POST_TEXT, post.getText());

            db.insertOrThrow(TABLE_NAME, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("db", "Error during the insert process in PostDAO");
        } finally {
            db.endTransaction();
        }
    }
}
