package com.act.service;

import java.util.*;

import com.act.dao.BookRecordRepository;
import com.act.dao.BookRepository;
import com.act.dao.PagesReadRepository;
import com.act.entity.*;
import com.act.entity.dto.AuthorDTO;
import com.act.entity.dto.BookDTO;
import com.act.entity.dto.UserDTO;
import com.act.entity.dto.UserDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.act.dao.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private PagesReadRepository pagesReadRepository;

	@Autowired
	private BookRecordRepository bookRecordRepository;
	
	
	public List<UserDTO> getAllUsers(){

		Optional<List<UserDTO>> users = userRepository.fetchUsersDTO();
	
		return users.get() == null ? Collections.emptyList() : users.get();
	}

	public User getUserById(int userId){
		Optional<User> userInstance = userRepository.findById(userId);
		User user = userInstance.get();
		return userInstance.orElse(null);
	}

	public UserDetailDTO getUserDetailById(int userId) {

		Optional<User> userInstance = userRepository.findById(userId);
		User user = userInstance.get();

		Optional<List<Book>> optionalUserBooks = bookRepository.fetchBooksDtoByUserId(userId);

		List<Book> userBooks = optionalUserBooks.get();

		List<BookDTO> userBooksDTO = new ArrayList<>();

		for(Book book: userBooks){
			AuthorDTO author = new AuthorDTO(
					book.getAuthor().getId(),
					book.getAuthor().getFirstName(),
					book.getAuthor().getMiddleName(),
					book.getAuthor().getLastName(),
					book.getAuthor().getAbout());

			userBooksDTO.add(
					new BookDTO(
							book.getId(),
							book.getTitle(),
							book.getDescription(),
							book.getTotalPages(),
							book.getBookRating(),
							book.getCategory().getCategoryName(),
							author)
			);
		}

		UserDetailDTO userDetailDTO = new UserDetailDTO(user.getId(),
					user.getFirstName(),
					user.getLastName(),
					user.getUserName(),
					userBooksDTO );

		return userDetailDTO;
	}
	
	public User saveNewUser(User user) {
		user.setId(0);
		return userRepository.save(user);
	}

	public UserDetailDTO addBook(int userId, Book book) {
		Optional<User> userInstance = userRepository.findById(userId);

		if (userInstance.isPresent()) {
			User user = userInstance.get();

			Book b = null;
			if (!(book == null)) {
				b = bookRepository.save(book);

				PagesRead pr = new PagesRead(new Date(), 0);
				pr = pagesReadRepository.save(pr);

				BookRecordId brId = new BookRecordId(user.getId(), book.getId(), pr.getId());
				BookRecord br = new BookRecord(b, user, pr);
				br.setId(brId);

				br = bookRecordRepository.save(br);

				user.getBookRecords().add(br);

				userRepository.save(user);
				return getUserDetailById(user.getId());
			}
		}
		return null;
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
