package com.bookstore.api.resource;


import com.bookstore.api.response.BaseResponse;
import com.bookstore.model.CITY;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookStoreResource extends BaseResponse{

	private String name;
	private CITY city;
	
	private BookStoreResource(BookStoreResourceBuilder builder) {
		this.name=builder.name;
		this.city=builder.city;
		this.responseId=builder.id;
	}
	
	public static class BookStoreResourceBuilder{
		private Long id;
		private String name;
		private CITY city;
		
		public BookStoreResourceBuilder name(String name) {
			this.name=name;
		    return this;
		}
		
		public BookStoreResourceBuilder city(CITY city) {
			this.city=city;
		    return this;
		}
		
		public BookStoreResource build(Long id) {
			this.id=id;
			return new BookStoreResource(this);
		}
	}
	
	public static BookStoreResourceBuilder builder() {
		return new BookStoreResourceBuilder();
	}
	
}
