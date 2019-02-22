package com.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
public class Category extends AuditModel implements HasId{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	public Category(CategoryBuilder builder) {
		this.name=builder.name;
	}
	
	public static class CategoryBuilder{
		private String name;
		public Category build() {
			return new Category(this);
		}
		
		public CategoryBuilder name(String name) {
			this.name=name;
			return this;
		}
	}
	
	public static CategoryBuilder builder() {
		return new CategoryBuilder();
	}

}
