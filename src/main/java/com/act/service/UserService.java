package com.act.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.act.dao.UserRepository;
import com.act.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> getAllUsers(){
		
		List<User> users = userRepository.findAll();
	
		return users == null ? Collections.emptyList() : users;
	}
	
	public User getUserById(int userId) {
		
		Optional<User> userInstance = userRepository.findById(userId);
		
		return userInstance.orElse(null);
	}
	
	public User saveNewUser(User user) {
		user.setId(0);
		return userRepository.save(user);
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	private String ifUserDelete(User user) {
		String response = "User ";
		
		if(user == null) {
			response += "Not Found!!!";
		} else {
			response += " with id: " + user.getId();
			userRepository.deleteById(user.getId());
			response += " Deleted...";
		}
		return response;
	}
	
	public String deleteUser(int userId) {
			
		Optional<User> userInstance = userRepository.findById(userId);
		
		return this.ifUserDelete(userInstance.orElse(null));
	}
}
