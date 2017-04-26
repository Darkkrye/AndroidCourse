package com.example.pierre.sqlexercice.DB.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.pierre.sqlexercice.DB.DatabaseHelper;
import com.example.pierre.sqlexercice.Model.Author;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.pierre.sqlexercice.MainActivity.TAG;

/**
 * Created by Pierre on 11/04/2017.
 */

public class AuthorDAO {
    public static final String TABLE_NAME = "author";

    // Columns
    private static final String KEY_AUHTOR_ID = "id_author";
    private static final String KEY_AUTHOR_FIRSTNAME = "firstname";
    private static final String KEY_AUTHOR_LASTNAME = "lastname";
    private static final String KEY_AUTHOR_CREATEDDATE = "created_date";

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            "(" +
            KEY_AUHTOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            KEY_AUTHOR_FIRSTNAME + " VARCHAR(255)," +
            KEY_AUTHOR_LASTNAME + " VARCHAR(255)," +
            KEY_AUTHOR_CREATEDDATE + " DATETIME" +
            ")";

    public static void insert(Context context, Author author) {
        DatabaseHelper helper = DatabaseHelper.getSharedInstance(context.getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_AUTHOR_FIRSTNAME, author.getFirstname());
            values.put(KEY_AUTHOR_LASTNAME, author.getLastname());
            values.put(KEY_AUTHOR_CREATEDDATE, String.valueOf(author.getCreatedDate()));

            db.insertOrThrow(TABLE_NAME, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("db", "Error during the insert process in AuthorDAO");
            Log.d("db", e.getMessage());
        } finally {
            db.endTransaction();
        }
    }

    public static ArrayList<Author> selects(Context context) {
        DatabaseHelper helper = DatabaseHelper.getSharedInstance(context.getApplicationContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        db.beginTransaction();
        ArrayList<Author> authors = new ArrayList<Author>();

        try {
            // ContentValues values = new ContentValues();
            // values.put(KEY_AUTHOR_FIRSTNAME, author.getFirstname());

            Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
            c.moveToFirst();

            for (int i = 0; i < c.getCount(); i++) {
                // Log.d("db", "select: " + c.getString(0) + " " + c.getString(1) + " " + c.getString(2) + " " + c.getString(3));

                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                Author a = new Author(c.getString(1), c.getString(2), new Date());
                a.setId(Integer.parseInt(c.getString(0)));

                authors.add(a);
                c.moveToNext();
            }

            Log.d("db", "select count: " + c.getCount());
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("db", "Error during the select process in AuthorDAO");
            Log.d("db", e.getMessage());
        } finally {
            db.endTransaction();
        }

        return authors;
    }
}
