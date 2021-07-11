package com.act.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Author {
	
	@Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;

	@NotBlank(message="author firstname may not be null")
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@NotBlank(message="author lastname may not be null")
	@Column(name = "last_name")
	private String lastName;

	@NotBlank(message="author about may not be null")
	@Column(name = "about")
	private String about;
	
	@JsonIgnore
	@OneToMany(mappedBy = "author",
				cascade = {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH })
	private List<Book> books;
	
	public Author() { }

	public Author(String firstName, String middleName, String lastName, String about) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.about = about;
	}

	public void addBook(Book book) {
		
		if(books == null) {
			books = new ArrayList<>();
		}
		
		books.add(book);
		
		book.setAuthor(this);	
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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", middleName='" + middleName + '\'' +
				", lastName='" + lastName + '\'' +
				", about='" + about + '\'' +
				'}';
	}
}
