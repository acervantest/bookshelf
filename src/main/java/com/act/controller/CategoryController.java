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

import com.act.entity.Category;
import com.act.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/categories")
	public List<Category> findAllCategories() {
		return categoryService.getAllCategories();
	}
	
	@GetMapping("/categories/{categoryId}")
	public Category findCategoryById(@PathVariable int categoryId) {
		return categoryService.getCategoryById(categoryId);
	}
	
	@PostMapping("/categories")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.saveNewCategory(category);
	}
	
	@PutMapping("/categories")
	public Category updateCategory(@RequestBody Category category) {
		return categoryService.updateCategory(category);
	}
	
	@DeleteMapping("/categories/{categoryId}")
	public String deleteCategory(@PathVariable int categoryId) {		
		return categoryService.deleteCategory(categoryId);
	}
}
