package com.act.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.act.entity.dto.UserDTO;
import com.act.entity.dto.UserDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.act.dao.UserRepository;
import com.act.entity.User;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public List<UserDTO> getAllUsers(){
		
		Optional<List<UserDTO>> users = userRepository.fetchUsersDTO();

		List<UserDTO> usersDTO = users.get();
	
		return usersDTO == null ? Collections.emptyList() : usersDTO;
	}

	public User getUserById(int userId){
		Optional<User> userInstance = userRepository.findById(userId);
		User user = userInstance.get();
		return userInstance.orElse(null);
	}

	public UserDetailDTO getUserDetailById(int userId) {

		Optional<User> userInstance = userRepository.fetchFullUser(userId);

		User user = userInstance.get();

		UserDetailDTO userDetailDTO = new UserDetailDTO(user.getId(),
				user.getFirstName(),
				user.getLastName(),
				user.getUsername(),
				user.getBooksRecord() );
		return userDetailDTO;
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
