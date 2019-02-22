package com.bookstore.api.mapper;

import com.bookstore.api.resource.ApiResource;
import com.bookstore.model.HasId;

public abstract class Mapper<R extends ApiResource,M extends HasId > {
	
	public abstract M mapToModel(R resource);
	public abstract R mapToRequest(M model);

}
