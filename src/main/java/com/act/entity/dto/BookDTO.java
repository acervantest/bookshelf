package com.act.entity.dto;

public class BookDTO{

    private int id;
    private String  title;
    private String description;
    private int pages;
    private int rating;
    private String category;
    private AuthorDTO author;

    public BookDTO() { }

    public BookDTO(int id, String title, String description, int pages, int rating, String category, AuthorDTO author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pages = pages;
        this.rating = rating;
        this.category = category;
        this.author = author;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
