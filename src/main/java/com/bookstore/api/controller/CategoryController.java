package com.bookstore.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
     
import com.bookstore.api.mapper.CategoryMapper;
import com.bookstore.api.request.CategoryRequest;
import com.bookstore.api.resource.CategoryResource;
import com.bookstore.api.resource.CategoryResourceCollection;
import com.bookstore.api.response.BaseResponse;
import com.bookstore.model.Category;
import com.bookstore.service.CategoryService;

@RestController
@RequestMapping(path="/api/category")
public class CategoryController {
	
	private CategoryService categoryService;
	private CategoryMapper mapper;
	
	@PostMapping
	public BaseResponse create(@RequestBody CategoryRequest request) {
		Category category = mapper.mapToModel(request.getResource());
		category = categoryService.add(category);
		return BaseResponse.baseBuilder().responseId(category.getId()).build();
	}
	
	@GetMapping
	public CategoryResourceCollection books() {
		List<Category> categories = categoryService.findAll();
		List<CategoryResource> collection = categories.stream().map(c-> CategoryResource.builder().name(c.getName()).build(c.getId())).collect(Collectors.toList());
		return CategoryResourceCollection.builder().resources(collection).build();
	}
	

}
