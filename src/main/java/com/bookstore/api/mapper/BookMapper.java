package com.bookstore.api.mapper;

import com.bookstore.api.resource.BookResource;
import com.bookstore.api.resource.CategoryResource;
import com.bookstore.model.Book;
import com.bookstore.model.Category;

public class BookMapper extends Mapper<BookResource, Book> {

	@Override
	public Book mapToModel(BookResource resource) {
		return null;
	}

	@Override
	public BookResource mapToRequest(Book model) {
		return null;
	}


}
