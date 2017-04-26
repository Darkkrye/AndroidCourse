package com.example.pierre.sqlexercice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.pierre.sqlexercice.DB.DAO.AuthorDAO;
import com.example.pierre.sqlexercice.DB.DAO.PostDAO;
import com.example.pierre.sqlexercice.Model.Author;
import com.example.pierre.sqlexercice.Model.Post;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static String TAG = "APPLI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("OKOK", "ici");
        //PostDAO.insert(this, new Post("titi"));

        //AuthorDAO.insert(this, new Author("Pierre", "BOUDON", new Date()));
        ArrayList<Author> authors = AuthorDAO.selects(this);

        for(Author a : authors) {
            Log.d("db", "select: " + a.getId() + " " + a.getFirstname() + " " + a.getLastname() + " " + a.getCreatedDate());
        }
    }
}
