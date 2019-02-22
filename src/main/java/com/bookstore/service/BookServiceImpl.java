package com.bookstore.service;

import org.springframework.stereotype.Service;

import com.bookstore.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	private BookRepository bookRepository;
	
}
