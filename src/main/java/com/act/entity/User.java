package com.act.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User {

	@Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String username;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<BookRecord> booksRecord;
	
	public User() { }

	public User(String firstName, String lastName, String username, List<BookRecord> booksRecord) {
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
