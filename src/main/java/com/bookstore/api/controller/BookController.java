package com.bookstore.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.api.mapper.BookMapper;
import com.bookstore.api.mapper.BookStoreMapper;
import com.bookstore.api.resource.BookResource;
import com.bookstore.api.resource.BookResourceCollection;
import com.bookstore.api.resource.BookStoreResource;
import com.bookstore.api.resource.BookStoreResourceCollection;
import com.bookstore.api.response.BaseResponse;
import com.bookstore.model.Book;
import com.bookstore.model.BookStore;
import com.bookstore.service.BookService;

@RestController
@RequestMapping(path="/api/book")
public class BookController {
	
	private BookService bookService;
	private BookMapper mapper;
	
	@PostMapping
	public BaseResponse create(@RequestBody BookResource request) {
		Book book = bookService.add(mapper.mapToModel(request));
		return BaseResponse.baseBuilder().responseId(book.getId()).build();
	}
	
	@GetMapping
	public BookStoreResourceCollection bookStores() {
		List<Book> books = bookService.findAll();
		List<BookResource> collection = books.stream().map(
				s->BookResource.builder().name(s.getName()).basePrice(s.getBasePrice()).bookStores(s.getStores()).category(s.getCategory()).build(s.getId())
				).collect(Collectors.toList());
		return BookStoreResourceCollection.builder().resources(collection).build();
	}
	

}
