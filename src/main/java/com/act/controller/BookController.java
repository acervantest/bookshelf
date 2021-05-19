package com.act.controller;

import java.util.List;

import com.act.entity.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.act.entity.Book;
import com.act.service.BookService;


@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	@GetMapping("/books")
	public List<Book> findAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/books/{bookId}")
	public Book findBookById(@PathVariable int bookId) {
		return bookService.getBookById(bookId);
	}

	@PostMapping("/books")
	public BookDTO addBook(@RequestBody Book book) {
		return bookService.saveNewBook(book);
	}
	
	@PutMapping("/books")
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	
	@DeleteMapping("/books/{bookId}")
	public String deleteBook(@PathVariable int bookId) {
		return bookService.deleteBook(bookId);
	}
}
