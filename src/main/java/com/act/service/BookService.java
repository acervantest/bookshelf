package com.act.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.act.dao.BookRepository;
import com.act.entity.Book;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	
	public List<Book> getAllBooks(){
		
		List<Book> books = bookRepository.findAll();
	
		return books == null ? Collections.emptyList() : books;
	}
	
	public Book getBookById(int bookId) {
		
		Optional<Book> bookInstance = bookRepository.findById(bookId);
		
		return bookInstance.orElse(null);
	}
	
	public Book saveNewBook(Book book) {
		book.setId(0);
		return bookRepository.save(book);
	}
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	private String ifBookDelete(Book book) {
		String response = "Book ";
		
		if(book == null) {
			response += "Not Found!!!";
		} else {
			response += " with id: " + book.getId();
			bookRepository.deleteById(book.getId());
			response += " Deleted...";
		}
		return response;
	}
	
	public String deleteBook(int bookId) {
			
		Optional<Book> bookInstance = bookRepository.findById(bookId);
		
		return this.ifBookDelete(bookInstance.orElse(null));
	}
}
