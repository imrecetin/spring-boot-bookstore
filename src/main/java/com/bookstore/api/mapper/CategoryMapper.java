package com.bookstore.api.mapper;

import org.springframework.stereotype.Component;

import com.bookstore.api.resource.CategoryResource;
import com.bookstore.model.Category;

@Component
public class CategoryMapper extends Mapper<CategoryResource, Category> {

	@Override
	public Category mapToModel(CategoryResource resource) {
		return Category.builder().name(resource.getName()).build();
	}

	@Override
	public CategoryResource mapToRequest(Category model) {
		return CategoryResource.builder().name(model.getName()).build();
	}

}
