package com.act.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name="BookRecord")
@Table(name = "book_record")
public class BookRecord {

	@EmbeddedId
	private BookRecordId id;

	@ManyToOne
	@MapsId("bookId")
	private Book book;

	@ManyToOne
	@MapsId("userId")
	private User user;

	@ManyToOne
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
