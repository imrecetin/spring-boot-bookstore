package com.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	public Book findBookBy(Long bookStoreId);

	public List<Book> findByCategoryAndBookStore(Long categoryID, Long bookStoreID);

}
