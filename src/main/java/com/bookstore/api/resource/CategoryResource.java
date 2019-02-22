package com.bookstore.api.resource;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryResource extends ApiResource {
	
	private String name;
	
	private  CategoryResource(CategoryResourceBuilder builder) {
		this.name=builder.name;
	}
	
	public static class CategoryResourceBuilder{
		private String name;
		
		public CategoryResourceBuilder name(String name) {
			this.name=name;
			return this;
		}
		
		public CategoryResource build() {
			return new CategoryResource(this);
		}
	}
	
	public static CategoryResourceBuilder builder() {
		return new CategoryResourceBuilder();
	}

}
