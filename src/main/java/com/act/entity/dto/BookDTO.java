package com.act.entity.dto;

public class BookDTO {

    private int bookId;
    private String bookTitle;
    private String bookDescription;
    private int bookPages;
    private int bookRating;
    private String bookCategory;
    private AuthorDTO bookAuthor;

    public BookDTO() { }

    public BookDTO(int bookId, String bookTitle, String bookDescription, int bookPages, int bookRating, String bookCategory, AuthorDTO bookAuthor) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookDescription = bookDescription;
        this.bookPages = bookPages;
        this.bookRating = bookRating;
        this.bookCategory = bookCategory;
        this.bookAuthor = bookAuthor;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public int getBookPages() {
        return bookPages;
    }

    public void setBookPages(int bookPages) {
        this.bookPages = bookPages;
    }

    public int getBookRating() {
        return bookRating;
    }

    public void setBookRating(int bookRating) {
        this.bookRating = bookRating;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public AuthorDTO getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(AuthorDTO bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
}
