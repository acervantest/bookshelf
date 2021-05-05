package com.act.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

	
	public List<Category> getAllCategories(){
		
		List<Category> categories = categoryRepository.findAll();
	
		return categories == null ? Collections.emptyList() : categories;
	}
	
	public Category getCategoryById(int categoryId) {
		
		Optional<Category> categoryInstance = categoryRepository.findById(categoryId);
		
		return categoryInstance.orElse(null);
	}
	
	public Category saveNewCategory(Category category) {
		category.setId(0);
		return categoryRepository.save(category);
	}
	
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	private String ifCategoryDelete(Category category) {
		String response = "Category ";
		
		if(category == null) {
			response += "Not Found!!!";
		} else {
			response += " with id: " + category.getId();
			categoryRepository.deleteById(category.getId());
			response += " Deleted...";
		}
		return response;
	}
	
	public String deleteCategory(int categoryId) {
			
		Optional<Category> categoryInstance = categoryRepository.findById(categoryId);
		
		return this.ifCategoryDelete(categoryInstance.orElse(null));
	}
}
