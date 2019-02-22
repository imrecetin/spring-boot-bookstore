package com.bookstore.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
public class Book extends AuditModel implements HasId{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToOne
    @JoinColumn
	private Category category;
	@ManyToMany(mappedBy = "books")
	private List<BookStore> stores;
	private BigDecimal basePrice;
	
	public Book(BookBuilder builder) {
		this.id=builder.id;
		this.category=builder.category;
		this.name=builder.name;
		this.stores=builder.stores;
		this.basePrice=builder.basePrice;
	}
	
	public BigDecimal calculateStorePrice(BookStore store) {
		return basePrice.multiply(store.getCity().getBookStorePriceConstant());
	}
	
	public static class BookBuilder{
		private Long id;
		private String name;
		private Category category;
		private List<BookStore> stores;
		private BigDecimal basePrice;
		
		public BookBuilder name(String name) {
			this.name=name;
			return this;
		}
		
		public BookBuilder category(Category category) {
			this.category=category;
			return this;
		}
		
		public BookBuilder stores(List<BookStore> stores) {
			this.stores=stores;
			return this;
		}
		
		public BookBuilder basePrice(BigDecimal basePrice) {
			this.basePrice=basePrice;
			return this;
		}
		
		public Book build(Long id) {
			this.id=id;
			return new Book(this);
		}
		
	}
	
	public static BookBuilder builder() {
		return new BookBuilder();
	}

}
