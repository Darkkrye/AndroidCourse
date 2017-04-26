package com.example.pierre.sqlexercice.Model;

import java.util.Date;
import java.util.List;

/**
 * Created by Pierre on 11/04/2017.
 */

public class Book {
    private int id;
    private String title;
    private Library library;
    private Date createdDate;
    private List<Author> authors;

    public Book(int id, String title, Library library, Date createdDate) {
        this.id = id;
        this.title = title;
        this.library = library;
        this.createdDate = createdDate;
    }

    public Book(int id, String title, Library library, Date createdDate, List<Author> authors) {
        this.id = id;
        this.title = title;
        this.library = library;
        this.createdDate = createdDate;
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
