package com.bookstore.service;

import java.util.List;

import com.bookstore.model.BookStore;
import com.bookstore.model.Category;

public interface BookStoreService {

	public BookStore add(BookStore model);

	public List<BookStore> findAll();

	public void deleteBookById(Long bookStoreId, Long bookID);

}
