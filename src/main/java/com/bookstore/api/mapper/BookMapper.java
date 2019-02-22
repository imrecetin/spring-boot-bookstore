package com.bookstore.api.mapper;

import com.bookstore.api.resource.CategoryResource;
import com.bookstore.model.Category;

public class BookMapper extends Mapper<CategoryResource, Category> {

	@Override
	public Category mapToModel(CategoryResource resource) {
		return Category.builder().name(resource.getName()).build();
	}

	@Override
	public CategoryResource mapToRequest(Category model) {
		return CategoryResource.builder().name(model.getName()).build();
	}

}
