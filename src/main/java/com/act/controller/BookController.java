package com.act.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.act.dao.AuthorRepository;
import com.act.dao.BookRepository;
import com.act.entity.Author;
import com.act.entity.Book;

@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@GetMapping("/books")
	public List<Book> findAllBooks() {
		List<Book> myBooks = bookRepository.findAll(); 
		return myBooks;
	}
	
	@GetMapping("/authors")
	public List<Author> findAllAuthors() {
		List<Author> myAuthors = authorRepository.findAll(); 
		return myAuthors;
	}
	
	@GetMapping("/")
    String index() {
        return "Hello, World!";
    }
}
