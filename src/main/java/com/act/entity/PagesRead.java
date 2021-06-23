package com.act.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "pages_read")
public class PagesRead {

	@Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "pages read day may not be null")
	private Date day;

	@Column(name = "num_of_pages")
	@Range(min = 1, message="pages read may not be null")
	private int pages;

	@JsonIgnore
	@OneToMany(mappedBy = "pages")
	private Set<BookRecord> bookRecords = new HashSet<>();

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

	public Set<BookRecord> getBookRecords() {
		return bookRecords;
	}

	public void setBookRecords(Set<BookRecord> bookRecords) {
		this.bookRecords = bookRecords;
	}
}
