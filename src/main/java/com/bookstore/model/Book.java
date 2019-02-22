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

@Entity
@Table(name = "book")
@Data
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
	
	public BigDecimal calculateStorePrice(BookStore store) {
		return basePrice.multiply(store.getCity().getBookStorePriceConstant());
	}
	
}
