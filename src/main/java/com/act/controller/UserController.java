package com.act.controller;

import java.util.List;

import com.act.entity.Book;
import com.act.entity.dto.UserDTO;
import com.act.entity.dto.UserDetailDTO;
import com.act.exceptions.NotFoundResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.act.entity.User;
import com.act.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<UserDTO> findAllUsers() {
		return userService.getAllUsers();	
	}
	
	@GetMapping("/users/{userId}")
	public UserDetailDTO findUserDetailById(@PathVariable int userId) {

		UserDetailDTO fetchedUser = userService.getUserDetailById(userId);

		if( fetchedUser == null ) throw new NotFoundResponse(" USER "+ userId +" NOT FOUND ");

		return fetchedUser;
	}

	@GetMapping("/user/{userId}")
	public User findUserById(@PathVariable int userId) {

		User fetchedUser = userService.getUserById(userId);

		if( fetchedUser == null ) throw new NotFoundResponse(" USER "+ userId +" NOT FOUND ");

		return fetchedUser;
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return userService.saveNewUser(user);
	}

	@PostMapping("/users/{userId}")
	public UserDetailDTO addBook(@PathVariable int userId, @RequestBody Book book) {
		return userService.addBook(userId, book);
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/user/{userId}")
	public String deleteUser(@PathVariable int userId) {
		return userService.deleteUser(userId);
	}
}
