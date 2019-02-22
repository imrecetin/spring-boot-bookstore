package com.bookstore.api.resource;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.bookstore.api.response.BaseResponse;
import com.bookstore.model.BookStore;
import com.bookstore.model.Category;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookResource extends BaseResponse{

	private String name;
	private CategoryResource category;
	private List<BookStoreResource> bookStores;
	private BigDecimal basePrice;
	private BigDecimal bookStorePrice;
	
	private BookResource(BookResourceBuilder builder) {
		this.name=builder.name;
		this.category=builder.category;
		this.basePrice=builder.basePrice;
		this.bookStorePrice=builder.bookStorePrice;
		this.responseId=builder.id;
	}
	
	public static class BookResourceBuilder{
		private Long id;
		private String name;
		private CategoryResource category;
		private List<BookStoreResource> bookStores;
		private BigDecimal basePrice;
		private BigDecimal bookStorePrice;
		
		public BookResourceBuilder name(String name) {
			this.name=name;
		    return this;
		}
		
		public BookResourceBuilder category(Category category) {
			this.category=CategoryResource.builder().name(category.getName()).build(category.getId());
		    return this;
		}
		
		public BookResourceBuilder bookStores(List<BookStore> bookStores) {
			List<BookStoreResource> mappedBookStore = bookStores.stream().map(s->BookStoreResource.builder().name(s.getName()).city(s.getCity()).build(s.getId())).collect(Collectors.toList());
			this.bookStores=mappedBookStore;
		    return this;
		}
		
		
		public BookResourceBuilder basePrice(BigDecimal basePrice) {
			this.basePrice=basePrice;
		    return this;
		}
		
		public BookResourceBuilder bookStorePrice(BigDecimal bookStorePrice) {
			this.bookStorePrice=bookStorePrice;
		    return this;
		}
		
		public BookResource build(Long id) {
			this.id=id;
			return new BookResource(this);
		}
	}
	
	public static BookResourceBuilder builder() {
		return new BookResourceBuilder();
	}
	
}
