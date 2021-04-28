package com.act.entity;

import javax.persistence.*;


@Entity
public class Book {
	
	@Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "total_pages")
	private int totalPages;
	
	@Column(name = "book_rating")
	private int bookRating;
	
	@OneToOne(cascade={ CascadeType.MERGE }, fetch=FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne(cascade = { CascadeType.MERGE }, fetch=FetchType.EAGER)
	@JoinColumn(name = "author_id")
	private Author author;
	
	public Book() { }
	
	public Book(String title, String description, int totalPages, int bookRating, Category category, Author author) {
		this.title = title;
		this.description = description;
		this.totalPages = totalPages;
		this.bookRating = bookRating;
		this.category = category;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getBookRating() {
		return bookRating;
	}

	public void setBookRating(int bookRating) {
		this.bookRating = bookRating;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
}
