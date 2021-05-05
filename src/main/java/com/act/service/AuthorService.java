package com.act.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
	
	
	public List<Author> getAllAuthors(){
		
		List<Author> authors = authorRepository.findAll();
	
		return authors == null ? Collections.emptyList() : authors;
	}
	
	public Author getAuthorById(int authorId) {
		
		Optional<Author> authorInstance = authorRepository.findById(authorId);
		
		return authorInstance.orElse(null);
	}
	
	public Author saveNewAuthor(Author author) {
		author.setId(0);
		return authorRepository.save(author);
	}
	
	public Author updateAuthor(Author author) {
		return authorRepository.save(author);
	}
	
	private String ifAuthorDelete(Author author) {
		String response = "Author ";
		
		if(author == null) {
			response += "Not Found!!!";
		} else {
			response += " with id: " + author.getId();
			authorRepository.deleteById(author.getId());
			response += " Deleted...";
		}
		return response;
	}
	
	public String deleteAuthor(int authorId) {
			
		Optional<Author> authorInstance = authorRepository.findById(authorId);
		
		return this.ifAuthorDelete(authorInstance.orElse(null));
	}	
	
}
