package com.act.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.act.exceptions.NotFoundException;
import com.act.validators.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.act.dao.AuthorRepository;
import com.act.entity.Author;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private ValidatorService validatorService;
	
	
	public List<Author> getAllAuthors(){
		
		List<Author> authors = authorRepository.findAll();
	
		return authors == null ? Collections.emptyList() : authors;
	}
	
	public Author getAuthorById(int authorId) {
		
		Optional<Author> authorInstance = authorRepository.findById(authorId);

		if(!authorInstance.isPresent()) throw new NotFoundException("AUTHOR [ "+ authorId +" ] NOT FOUND");
		
		return authorInstance.get();
	}
	
	public Author saveNewAuthor(Author author) {

		validatorService.validate(author, Author.class);

		author.setId(0);

		return authorRepository.save(author);
	}
	
	public Author updateAuthor(Author author) {

		validatorService.validate(author, Author.class);

		return authorRepository.save(author);
	}

	public String deleteAuthorById(int authorId){

		Author author = getAuthorById(authorId);

		authorRepository.delete(author);

		return "Author with id [ " + authorId + " ] DELETED...";
	}
}
