package com.example.pierre.sqlexercice.Model;

import java.util.Date;

/**
 * Created by Pierre on 11/04/2017.
 */

public class Loan {
    private int id;
    private User user;
    private Book book;
    private Date created_date;
    private Date end_date;

    public Loan(int id, User user, Book book, Date created_date, Date end_date) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.created_date = created_date;
        this.end_date = end_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
