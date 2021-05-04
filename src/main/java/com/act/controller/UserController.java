package com.act.controller;

import java.util.List;

import com.act.exceptions.NotFoundResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.act.entity.User;
import com.act.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> findAllUsers() {	
		return userService.getAllUsers();	
	}
	
	@GetMapping("/users/{userId}")
	public User findUserById(@PathVariable int userId) {	

		User fetchedUser = userService.getUserById(userId);

		if( fetchedUser == null ) throw new NotFoundResponse(" USER "+ userId +" NOT FOUND ");

		return fetchedUser;
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return userService.saveNewUser(user);
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
