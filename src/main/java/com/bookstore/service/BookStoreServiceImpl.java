package com.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bookstore.model.BookStore;
import com.bookstore.repository.BookStoreRepository;

@Service
@Transactional
public class BookStoreServiceImpl implements BookStoreService{

	private BookStoreRepository bookStoreRepository;

	@Override
	public BookStore add(BookStore model) {
		return bookStoreRepository.save(model);
	}

	@Override
	public List<BookStore> findAll() {
		return bookStoreRepository.findAll();
	}

	@Override
	public void deleteBookById(Long bookStoreId, Long bookID) {
		bookStoreRepository.deleteBookById(bookStoreId,bookID);
	}
	
}
