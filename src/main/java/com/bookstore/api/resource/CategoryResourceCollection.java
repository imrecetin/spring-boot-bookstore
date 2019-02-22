package com.bookstore.api.resource;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryResourceCollection extends ResourceCollection<CategoryResource> {
	
	public static CategoryResourceCollectionBuilder builder() {
		return new CategoryResourceCollectionBuilder();
	}
	
	public CategoryResourceCollection(CategoryResourceCollectionBuilder builder) {
		this.resources=builder.resources;
	}
	
	public static class CategoryResourceCollectionBuilder{
		
		private List resources;

		public CategoryResourceCollection build() {
			return new CategoryResourceCollection(this);
		}
		
		public CategoryResourceCollectionBuilder resources(List resources) {
			this.resources=resources;
			return this;
		}
	}
	
}
