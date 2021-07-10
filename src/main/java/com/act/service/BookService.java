package com.act.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.act.dao.BookRecordRepository;
import com.act.entity.BookRecord;
import com.act.entity.dto.BookDTO;
import com.act.exceptions.NotFoundException;
import com.act.mappers.BookMapper;
import com.act.validators.ValidatorService;
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

	@Autowired
	private BookRecordRepository bookRecordRepository;

	@Autowired
	private BookMapper bookMapper;

	@Autowired
	private ValidatorService validatorService;


	public List<Book> getAllBooks(){
		
		List<Book> books = bookRepository.findAll();
	
		return books == null ? Collections.emptyList() : books;
	}
	
	public Book getBookById(int bookId) {
		
		Optional<Book> bookInstance = bookRepository.findById(bookId);

		if(!bookInstance.isPresent()) throw new NotFoundException("BOOK [ "+ bookId +" ] NOT FOUND");

		return bookInstance.get();
	}

	public List<Book> getBooksByUserId(int userId){

		Optional<List<Book>> optionalUserBooks = bookRepository.fetchBooksDtoByUserId(userId);

		return optionalUserBooks.orElse(null);
	}

	public Book saveBook(Book book){

		validatorService.validate(book, Book.class);

		book.setId(0);

		return bookRepository.save(book);
	}
	
	public BookDTO saveNewBook(Book book) {

		validatorService.validate(book, Book.class);

		book.setId(0);

		Book bookInstance = bookRepository.save(book);

		return bookMapper.convertToDto(bookInstance);
	}
	
	public Book updateBook(Book book) {

		validatorService.validate(book, Book.class);

		return bookRepository.save(book);
	}

	public String deleteBookById(int bookId) {

		Book bookInstance = getBookById(bookId);

		bookRepository.delete(bookInstance);

		return "Book with id [ " + bookId + " ] DELETED...";
	}

	public BookRecord saveBookRecord(BookRecord bookRecord){

		validatorService.validate(bookRecord, BookRecord.class);

		return bookRecordRepository.save(bookRecord);
	}
}
