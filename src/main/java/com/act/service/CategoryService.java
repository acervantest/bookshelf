package com.act.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.act.exceptions.NotFoundException;
import com.act.validators.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.act.dao.CategoryRepository;
import com.act.entity.Category;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ValidatorService validatorService;

	
	public List<Category> getAllCategories(){
		
		List<Category> categories = categoryRepository.findAll();
	
		return categories == null ? Collections.emptyList() : categories;
	}
	
	public Category getCategoryById(int categoryId) {
		
		Optional<Category> categoryInstance = categoryRepository.findById(categoryId);

		if(!categoryInstance.isPresent()) throw new NotFoundException("CATEGORY [ "+ categoryId +" ] NOT FOUND");
		
		return categoryInstance.get();
	}
	
	public Category saveNewCategory(Category category) {

		validatorService.validate(category, Category.class);

		category.setId(0);

		return categoryRepository.save(category);
	}
	
	public Category updateCategory(Category category) {

		validatorService.validate(category, Category.class);

		return categoryRepository.save(category);
	}

	public String deleteCategoryById(int categoryId){

		Category categoryInstance = getCategoryById(categoryId);

		categoryRepository.delete(categoryInstance);

		return "Category with id [ " + categoryId + " ] DELETED...";
	}
}
