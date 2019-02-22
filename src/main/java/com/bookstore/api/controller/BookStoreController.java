package com.bookstore.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.api.mapper.BookStoreMapper;
import com.bookstore.api.resource.BookResource;
import com.bookstore.api.resource.BookResourceCollection;
import com.bookstore.api.resource.BookStoreResource;
import com.bookstore.api.resource.BookStoreResourceCollection;
import com.bookstore.api.response.BaseResponse;
import com.bookstore.model.Book;
import com.bookstore.model.BookStore;
import com.bookstore.service.BookStoreService;

@RestController
@RequestMapping(path="/api/bookstore")
public class BookStoreController {
	
	private BookStoreService bookStoreService;
	private BookStoreMapper mapper;
	
	@PostMapping
	public BaseResponse create(@RequestBody BookStoreResource request) {
		BookStore bookStore = bookStoreService.add(mapper.mapToModel(request));
		return BaseResponse.baseBuilder().responseId(bookStore.getId()).build();
	}
	
	@GetMapping
	public BookStoreResourceCollection bookStores() {
		List<BookStore> bookStores = bookStoreService.findAll();
		List<BookStoreResource> collection = bookStores.stream().map(b-> BookStoreResource.builder().name(b.getName()).city(b.getCity()).build()).collect(Collectors.toList());
		return BookStoreResourceCollection.builder().resources(collection).build();
	}
	
	@DeleteMapping(path="/{bookStoreId}/book/{bookID}")
	public ResponseEntity<BaseResponse> deleteBook(@RequestParam Long bookStoreId,@RequestParam Long bookID) {
		bookStoreService.deleteBookById(bookStoreId,bookID);
		return ResponseEntity.ok().body(BaseResponse.baseBuilder().build());
	}
	
	@GetMapping(path="/{bookStoreId}/book/{bookID}")
	public BookResource findBook(@RequestParam Long bookStoreId,@RequestParam Long bookID) {
		Book book=bookStoreService.findBookBy(bookStoreId,bookID);
		BookStore bookStore = bookStoreService.findById(bookStoreId);
		return BookResource.builder()
				.name(book.getName())
				.basePrice(book.getBasePrice())
				.category(book.getCategory())
				.bookStorePrice(book.calculateStorePrice(bookStore))
				.build();
	}
	
	@GetMapping(path="/{bookStoreId}/book/")
	public BookResourceCollection  findBooks(@RequestParam Long bookStoreId) {
		List<Book> book=bookStoreService.findBooksBy(bookStoreId);
		return BookResourceCollection.builder()
				.resources(book.stream()
						.map(b->BookResource.builder().name(b.getName()).category(b.getCategory()).basePrice(b.getBasePrice())).collect(Collectors.toList()))
				.build();
	}
	

}
