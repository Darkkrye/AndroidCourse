package com.example.pierre.sqlexercice.Model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by vathenbala on 10/04/2017.
 */

public class Post {
    @Nullable
    private Integer id;
    @NonNull
    private String text;

    public Post(String text) {
        this(null, text);
    }

    public Post(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
