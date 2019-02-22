package com.bookstore.api.resource;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookStoreResourceCollection extends ResourceCollection<BookStoreResource> {
	
	public static BookStoreResourceCollectionBuilder builder() {
		return new BookStoreResourceCollectionBuilder();
	}
	
	public BookStoreResourceCollection(BookStoreResourceCollectionBuilder builder) {
		this.resources=builder.resources;
	}
	
	public static class BookStoreResourceCollectionBuilder{
		
		private List resources;

		public BookStoreResourceCollection build() {
			return new BookStoreResourceCollection(this);
		}
		
		public BookStoreResourceCollectionBuilder resources(List resources) {
			this.resources=resources;
			return this;
		}
	}

}
