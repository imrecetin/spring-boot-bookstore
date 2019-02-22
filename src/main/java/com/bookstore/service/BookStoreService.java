package com.bookstore.service;

import java.util.List;

import com.bookstore.model.Book;
import com.bookstore.model.BookStore;

public interface BookStoreService {

	public BookStore add(BookStore model);

	public List<BookStore> findAll();

	public void deleteBookById(Long bookStoreId, Long bookID);

	public Book findBookBy(Long bookStoreId, Long bookID);
	
	public List<Book> findBooksBy(Long bookStoreId);

	public Book findBookBy(Long bookStoreId);

	public BookStore findById(Long bookStoreId);

}
