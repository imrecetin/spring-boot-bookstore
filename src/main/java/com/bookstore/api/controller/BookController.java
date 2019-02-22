package com.bookstore.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.service.BookService;

@RestController
@RequestMapping(path="/api/book")
public class BookController {
	
	private BookService bookService;
	

}
