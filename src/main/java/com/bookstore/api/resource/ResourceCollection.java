package com.bookstore.api.resource;

import java.util.ArrayList;
import java.util.List;

public abstract class ResourceCollection<T extends ApiResource> {

	public List<T> resources=new ArrayList<T>();
}
