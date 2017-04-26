package com.example.pierre.sqlexercice.Model;

import java.util.Date;
import java.util.List;

/**
 * Created by Pierre on 11/04/2017.
 */

public class Author {
    private int id;
    private String firstname;
    private String lastname;
    private Date createdDate;
    private List<Book> books;

    public Author(String firstname, String lastname, Date createdDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.createdDate = createdDate;
    }

    public Author(int id, String firstname, String lastname, Date createdDate, List<Book> books) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.createdDate = createdDate;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
