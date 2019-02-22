package com.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookstore.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	public Book findBookBy(Long bookStoreId);

	@Query("SELECT b FROM Book b WHERE b.category.id=:categoryID and b.stores.id in (:bookStoreID)")
	public List<Book> findByCategoryAndBookStore(Long categoryID, Long bookStoreID);
	
	public Book update(Book model) ;

}
