package com.bookstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "bookstore")
@Data
public class BookStore extends AuditModel implements HasId{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Enumerated(EnumType.STRING)
	private CITY city;
	@ManyToMany(cascade = {
	        CascadeType.PERSIST,
	        CascadeType.MERGE
	    })
	    @JoinTable(name = "book",
	        joinColumns = @JoinColumn(name = "id"),
	        inverseJoinColumns = @JoinColumn(name = "id")
	    )
	private	List<Book> books;
	
	private BookStore(BookStoreBuilder builder) {
		this.name=builder.name;
		this.city=builder.city;
	}
	
	public static BookStoreBuilder builder() {
		return new BookStoreBuilder();
	}

	public static class BookStoreBuilder{
		private String name;
		private CITY city;
		private	List<Book> books;
		
		public BookStoreBuilder books(List<Book> books) {
			this.books=books;
		    return this;
		}
		
		public BookStoreBuilder name(String name) {
			this.name=name;
		    return this;
		}
		
		public BookStoreBuilder city(CITY city) {
			this.city=city;
		    return this;
		}
		
		public BookStore build() {
			return new BookStore(this);
		}
		
	}
	
}
