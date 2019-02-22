package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
		List<BookStore> bookStores = bookStoreRepository.findAll();
		if (CollectionUtils.isEmpty(bookStores)) {
			throw new RecordNotFoundException("BookStores No Found");
		}
		return bookStores;
	}

	@Override
	public void deleteBookById(Long bookStoreId, Long bookID) {
		bookStoreRepository.deleteBookById(bookStoreId,bookID);
	}

	@Override
	public Book findBookBy(Long bookStoreId, Long bookID) {
		Book book = bookStoreRepository.findBookBy(bookStoreId,bookID);
		if (!Optional.ofNullable(book).isPresent()) {
			throw new RecordNotFoundException("Book No Found");
		}
		return book;
	}

	@Override
	public List<Book> findBooksBy(Long bookStoreId) {
		List<Book> books = bookStoreRepository.findBooksBy(bookStoreId);
		if (CollectionUtils.isEmpty(books)) {
			throw new RecordNotFoundException("Books No Found");
		}
		return books;
	}

	@Override
	public Book findBookBy(Long bookStoreId) {
		Book book = bookRepository.findBookBy(bookStoreId);
		if (!Optional.ofNullable(book).isPresent()) {
			throw new RecordNotFoundException("Book No Found");
		}
		return book;
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
