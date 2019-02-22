package com.bookstore.api.resource;


import java.math.BigDecimal;

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
	private BigDecimal basePrice;
	private BigDecimal bookStorePrice;
	
	private BookResource(BookResourceBuilder builder) {
		this.name=builder.name;
		this.category=builder.category;
		this.basePrice=builder.basePrice;
		this.bookStorePrice=builder.bookStorePrice;
	}
	
	public static class BookResourceBuilder{
		private String name;
		private CategoryResource category;
		private BigDecimal basePrice;
		private BigDecimal bookStorePrice;
		
		public BookResourceBuilder name(String name) {
			this.name=name;
		    return this;
		}
		
		public BookResourceBuilder category(Category category) {
			this.category=CategoryResource.builder().name(category.getName()).build();
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
		
		public BookResource build() {
			return new BookResource(this);
		}
	}
	
	public static BookResourceBuilder builder() {
		return new BookResourceBuilder();
	}
	
}
