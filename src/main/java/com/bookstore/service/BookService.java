package com.bookstore.service;

import java.util.List;

import com.bookstore.model.Book;

public interface BookService {

	public Book add(Book model);

	public List<Book> findAll();

	public List<Book> findByCategoryAndBookStore(Long categoryID, Long bookStoreID);

	public Book update(Book model);

}
