package com.act.entity.dto;

import com.act.entity.BookRecord;

import java.util.List;

public class UserDetailDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private List<BookRecord> booksRecord;

    public UserDetailDTO() {}

    public UserDetailDTO(int id, String firstName, String lastName, String username, List<BookRecord> booksRecord) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.booksRecord = booksRecord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<BookRecord> getBooksRecord() {
        return booksRecord;
    }

    public void setBooksRecord(List<BookRecord> booksRecord) {
        this.booksRecord = booksRecord;
    }
}
