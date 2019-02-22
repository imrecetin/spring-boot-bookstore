package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.BookStore;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStore, Long> {

	void deleteBookById(Long bookStoreId, Long bookID);

}
