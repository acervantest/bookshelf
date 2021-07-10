package com.act.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.act.entity.Author;
import com.act.service.AuthorService;

@RestController
@RequestMapping("/api")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/authors")
	public List<Author> findAllAuthors() {	
		return authorService.getAllAuthors();	
	}
	
	@GetMapping("/authors/{authorId}")
	public Author findAuthorById(@PathVariable int authorId) {	
		return authorService.getAuthorById(authorId);
	}
	
	@PostMapping("/authors")
	public Author addAuthor(@RequestBody Author author) {
		return authorService.saveNewAuthor(author);
	}
	
	@PutMapping("/authors")
	public Author updateAuthor(@RequestBody Author author) {
		return authorService.updateAuthor(author);
	}
	
	@DeleteMapping("/authors/{authorId}")
	public String deleteAuthor(@PathVariable int authorId) {
		return authorService.deleteAuthorById(authorId);
	}
}