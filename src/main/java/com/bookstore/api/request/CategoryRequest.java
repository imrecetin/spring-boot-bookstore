package com.bookstore.api.request;

import com.bookstore.api.resource.ApiResource;
import com.bookstore.api.resource.CategoryResource;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryRequest extends ApiResource {

	private CategoryResource resource;
}
