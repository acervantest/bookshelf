package com.act.service;

import java.util.*;
import com.act.entity.*;
import com.act.entity.dto.*;
import com.act.dao.UserRepository;
import com.act.exceptions.NotFoundException;
import com.act.mappers.BookMapper;
import com.act.mappers.UserMapper;
import com.act.validators.ValidatorService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookService bookService;

	@Autowired
	private PagesReadService pagesReadService;

	@Autowired
	private BookMapper bookMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private ValidatorService validatorService;

	public List<UserDTO> getAllUsers(){

		Optional<List<UserDTO>> users = userRepository.fetchUsersDTO();
	
		return users.get() == null ? Collections.emptyList() : users.get();
	}

	public User getUserById(int userId){

		Optional<User> userInstance = userRepository.findById(userId);

		if(!userInstance.isPresent()) throw new NotFoundException(" USER [ "+ userId +" ] NOT FOUND");

		return userInstance.get();
	}

	public UserDetailDTO getUserDetailById(int userId) {

		User user = getUserById(userId);

		List<Book> userBooks = bookService.getBooksByUserId(userId);

		List<BookDTO> userBooksDTO = bookMapper.convertToDto(userBooks);

		return userMapper.convertToDto(user, userBooksDTO);
	}
	
	public User saveNewUser(User user) {

		validatorService.validate(user, User.class);

		user.setId(0);

		return userRepository.save(user);
	}

	public UserDetailDTO addBookToUser(int userId, Book book) {

		User user = getUserById(userId);

		validatorService.validate(book, Book.class);

		addBookToUser(user, book);

		return getUserDetailById(user.getId());
	}

	public User addBookToUser(User user, Book book){

		Book bookEntity = bookService.saveBook(book);

		PagesRead pagesReadEntity = new PagesRead(new Date(), 0);
		pagesReadEntity = pagesReadService.saveNewPagesRead(pagesReadEntity);

		BookRecordId bookRecordId = new BookRecordId(user.getId(), book.getId(), pagesReadEntity.getId());

		BookRecord bookRecord = new BookRecord(bookEntity, user, pagesReadEntity);
		bookRecord.setId(bookRecordId);

		bookRecord = bookService.saveBookRecord(bookRecord);

		user.getBookRecords().add(bookRecord);

		return userRepository.save(user);
	}

	public User updateUser(User user) {

		validatorService.validate(user, User.class);

		return userRepository.save(user);
	}

	public String deleteUserById(int userId){

		User userEntity = getUserById(userId);

		userRepository.delete(userEntity);

		return "User with id: [ " + userId + " ] DELETED...";
	}
}
