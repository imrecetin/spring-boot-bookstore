package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bookstore.model.Book;
import com.bookstore.model.BookStore;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.BookStoreRepository;
import com.bookstore.service.exception.RecordNotFoundException;

@Service
@Transactional
public class BookStoreServiceImpl implements BookStoreService{

	private BookStoreRepository bookStoreRepository;
	private BookRepository bookRepository;

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

	@Override
	public Book findBookBy(Long bookStoreId, Long bookID) {
		return bookStoreRepository.findBookBy(bookStoreId,bookID);
	}

	@Override
	public List<Book> findBooksBy(Long bookStoreId) {
		return bookStoreRepository.findBooksBy(bookStoreId);
	}

	@Override
	public Book findBookBy(Long bookStoreId) {
		return bookRepository.findBookBy(bookStoreId);
	}

	@Override
	public BookStore findById(Long bookStoreId) {
		Optional<BookStore> bookStore = bookStoreRepository.findById(bookStoreId);
		if (!bookStore.isPresent()) {
			throw new RecordNotFoundException("Not Found "+ bookStoreId);
		}
		return bookStore.get();
	}
	
}
