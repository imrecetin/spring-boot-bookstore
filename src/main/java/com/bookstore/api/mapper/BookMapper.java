package com.bookstore.api.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bookstore.api.resource.BookResource;
import com.bookstore.model.Book;

@Component
public class BookMapper extends Mapper<BookResource, Book> {
	
	private BookStoreMapper bookStoreMapper;
	private CategoryMapper categoryMapper;

	@Override
	public Book mapToModel(BookResource resource) {
		Book book = Book.builder().basePrice(resource.getBasePrice()).name(resource.getName()).category(categoryMapper.mapToModel(resource.getCategory())).
		stores(resource.getBookStores().stream().map(s-> bookStoreMapper.mapToModel(s)).collect(Collectors.toList())).build(resource.getResponseId());
		return book;
	}

	@Override
	public BookResource mapToRequest(Book model) {
		return null;
	}


}
