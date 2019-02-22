package com.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bookstore.model.Category;
import com.bookstore.repository.CategoryRepository;
import com.bookstore.service.exception.RecordNotFoundException;

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
		List<Category> categories = categoryRepository.findAll();
		if (CollectionUtils.isEmpty(categories)) {
			throw new RecordNotFoundException("Categories No Found");
		}
		return categories;
	}
	
}
