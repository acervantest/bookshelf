package com.act.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookRecordId implements Serializable{

	private static final long serialVersionUID = 1L;


	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "book_id")
	private int bookId;
	
	public BookRecordId() {}

	public BookRecordId(int userId, int bookId) {
		this.userId = userId;
		this.bookId = bookId;
	}

	public int getUserId() {
		return userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
}
