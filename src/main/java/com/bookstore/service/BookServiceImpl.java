package com.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.exception.RecordNotFoundException;

@Service
@Transactional
public class BookServiceImpl implements BookService{

	private BookRepository bookRepository;

	@Override
	public Book add(Book model) {
		return bookRepository.save(model);
	}

	@Override
	public List<Book> findAll() {
		List<Book> books = bookRepository.findAll();
		if (CollectionUtils.isEmpty(books)) {
			throw new RecordNotFoundException("Books No Found");
		}
		return books;
	}

	@Override
	public List<Book> findByCategoryAndBookStore(Long categoryID, Long bookStoreID) {
		List<Book> books = bookRepository.findByCategoryAndBookStore(categoryID,bookStoreID);
		if (CollectionUtils.isEmpty(books)) {
			throw new RecordNotFoundException("Books No Found CategoryID " + categoryID+ " BookStoreID "+ bookStoreID);
		}
		return books;
	}
	
}
