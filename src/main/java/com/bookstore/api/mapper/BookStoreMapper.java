package com.bookstore.api.mapper;

import org.springframework.stereotype.Component;

import com.bookstore.api.resource.BookStoreResource;
import com.bookstore.model.BookStore;

@Component
public class BookStoreMapper extends Mapper<BookStoreResource, BookStore> {

	@Override
	public BookStore mapToModel(BookStoreResource resource) {
		return BookStore.builder().name(resource.getName()).city(resource.getCity()).build(resource.getResponseId());
	}

	@Override
	public BookStoreResource mapToRequest(BookStore model) {
		return new BookStoreResource.BookStoreResourceBuilder().name(model.getName()).city(model.getCity()).build(model.getId());
	}


}
