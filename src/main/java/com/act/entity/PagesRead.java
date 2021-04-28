package com.act.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pages_read")
public class PagesRead {

	@Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	private Date day;

	@Column(name = "num_of_pages")
	private int pages;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumns({
		@JoinColumn( 
				name = "book_id",
				referencedColumnName = "book_id"),
		@JoinColumn( 
				name = "user_id",
				referencedColumnName = "user_id") })
	private BookRecord bookRecord;

	
	public PagesRead() {}
			
	public PagesRead(Date day, int pages) {
		this.day = day;
		this.pages = pages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public BookRecord getBookRecord() {
		return bookRecord;
	}

	public void setBookRecord(BookRecord bookRecord) {
		this.bookRecord = bookRecord;
	}
	
}
