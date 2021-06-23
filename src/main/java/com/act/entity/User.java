package com.act.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
public class User {

	@Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;

	@NotBlank(message="user's first name may not be null")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message="user's last name may not be null")
	@Column(name = "last_name")
	private String lastName;

	@NotBlank(message="user's username may not be null")
	@Column(name = "username")
	private String userName;

	@JsonIgnore
	@OneToMany(cascade = { CascadeType.REMOVE }, mappedBy = "user")
	private Set<BookRecord> bookRecords = new HashSet<>();
	
	public User() { }

	public User(String firstName, String lastName, String userName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<BookRecord> getBookRecords() {
		return bookRecords;
	}

	public void setBookRecords(Set<BookRecord> bookRecords) {
		this.bookRecords = bookRecords;
	}
}
