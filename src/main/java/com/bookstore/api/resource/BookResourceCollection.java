package com.bookstore.api.resource;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookResourceCollection extends ResourceCollection<BookResource> {
	
	public static BookResourceCollectionBuilder builder() {
		return new BookResourceCollectionBuilder();
	}
	
	public BookResourceCollection(BookResourceCollectionBuilder builder) {
		this.resources=builder.resources;
	}
	
	public static class BookResourceCollectionBuilder{
		
		private List resources;

		public BookResourceCollection build() {
			return new BookResourceCollection(this);
		}
		
		public BookResourceCollectionBuilder resources(List resources) {
			this.resources=resources;
			return this;
		}
	}

}
