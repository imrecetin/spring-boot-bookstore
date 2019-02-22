package com.bookstore.service;

import java.util.List;

import com.bookstore.model.Category;

public interface CategoryService {

	public Category add(Category category);
	public List<Category> findAll();

}
