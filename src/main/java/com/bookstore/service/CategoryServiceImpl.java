package com.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bookstore.model.Category;
import com.bookstore.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;

	@Override
	public Category add(Category category) {
		return categoryRepository.save(category);
	}
	
	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
}
