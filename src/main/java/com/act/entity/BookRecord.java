package com.act.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name="BookRecord")
@Table(name = "book_record")
public class BookRecord {

	@EmbeddedId
	private BookRecordId id;

	@NotNull(message = "book for book-record may not be null")
	@ManyToOne(cascade = CascadeType.REMOVE)
	@MapsId("bookId")
	private Book book;

	@NotNull(message = "user for book-record may not be null")
	@ManyToOne
	@MapsId("userId")
	private User user;

	@NotNull(message = "pages for book-record may not be null")
	@ManyToOne(cascade = CascadeType.REMOVE)
	@MapsId("pagesId")
	private PagesRead pages;

	public BookRecord() { }

	public BookRecord(Book book, User user, PagesRead pages) {
		this.book = book;
		this.user = user;
		this.pages = pages;
	}

	public BookRecordId getId() {
		return id;
	}

	public void setId(BookRecordId id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PagesRead getPages() {
		return pages;
	}

	public void setPages(PagesRead pages) {
		this.pages = pages;
	}

}
