package com.act.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "category_name")
	private String categoryName;
	
	public Category() { }
	
	
	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}