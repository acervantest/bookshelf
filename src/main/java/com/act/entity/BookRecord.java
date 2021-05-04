package com.act.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="BookRecord")
@Table(name = "book_record")
public class BookRecord {

	@EmbeddedId
	private BookRecordId id;
	
	@MapsId("bookId")
	@ManyToOne(fetch = FetchType.LAZY)
	private Book book;
	
	@JsonIgnore
	@MapsId("userId")
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@Column(name = "started_on")
	private Date startedOnDate;
	
	@Column(name = "returned_on")
	private Date finishedOnDate;
	
	@Column(name = "is_current")
	private boolean readingCurrently;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "bookRecord", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PagesRead> pagesRead;
	
	public BookRecord() {}
 
	public BookRecord(Book book, User user, Date startedOnDate) {
		this.book = book;
		this.user = user;
		this.id = new BookRecordId(user.getId(), book.getId());
		this.startedOnDate = startedOnDate;
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

	public Date getStartedOnDate() {
		return startedOnDate;
	}

	public void setStartedOnDate(Date startedOnDate) {
		this.startedOnDate = startedOnDate;
	}

	public Date getFinishedOnDate() {
		return finishedOnDate;
	}

	public void setFinishedOnDate(Date finishedOnDate) {
		this.finishedOnDate = finishedOnDate;
	}

	public boolean isReadingCurrently() {
		return readingCurrently;
	}

	public void setReadingCurrently(boolean readingCurrently) {
		this.readingCurrently = readingCurrently;
	}

	public List<PagesRead> getPagesReads() {
		return pagesRead;
	}

	public void setPagesReads(List<PagesRead> pagesRead) {
		this.pagesRead = pagesRead;
	}
	
}
