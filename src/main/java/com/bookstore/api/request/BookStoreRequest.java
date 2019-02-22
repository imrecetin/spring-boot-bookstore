package com.bookstore.api.request;

import com.bookstore.api.resource.ApiResource;
import com.bookstore.api.resource.BookStoreResource;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookStoreRequest extends ApiResource{

	private BookStoreResource resource;
}
