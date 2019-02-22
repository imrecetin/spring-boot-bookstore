package com.bookstore.api.resource;

import com.bookstore.api.response.BaseResponse;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryResource extends BaseResponse {
	
	private String name;
	
	private  CategoryResource(CategoryResourceBuilder builder) {
		this.name=builder.name;
		this.responseId=builder.id;
	}
	
	public static class CategoryResourceBuilder{
		private Long id;
		private String name;
		
		public CategoryResourceBuilder name(String name) {
			this.name=name;
			return this;
		}
		
		public CategoryResource build(Long id) {
			this.id=id;
			return new CategoryResource(this);
		}
	}
	
	public static CategoryResourceBuilder builder() {
		return new CategoryResourceBuilder();
	}

}
