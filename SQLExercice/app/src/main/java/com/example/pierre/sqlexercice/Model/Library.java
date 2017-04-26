package com.example.pierre.sqlexercice.Model;

import java.util.Date;

/**
 * Created by Pierre on 11/04/2017.
 */

public class Library {
    private int id;
    private String name;
    private Date createdDate;

    public Library(int id, String name, Date createdDate) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
