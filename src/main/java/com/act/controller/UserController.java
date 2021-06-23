package com.act.controller;

import java.util.List;
import com.act.entity.Book;
import com.act.entity.dto.UserDTO;
import com.act.entity.dto.UserDetailDTO;
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
	
	@GetMapping(value = "/users")
	public List<UserDTO> findAllUsers() {
		return userService.getAllUsers();	
	}
	
	@GetMapping("/users/{userId}")
	public UserDetailDTO findUserDetailById(@PathVariable int userId) {
		 return userService.getUserDetailById(userId);
	}

	@GetMapping("/user/{userId}")
	public User findUserById(@PathVariable int userId) {
		return userService.getUserById(userId);
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return userService.saveNewUser(user);
	}

	@PostMapping("/users/{userId}")
	public UserDetailDTO addBook(@PathVariable int userId, @RequestBody Book book) {
		return userService.addBookToUser(userId, book);
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
