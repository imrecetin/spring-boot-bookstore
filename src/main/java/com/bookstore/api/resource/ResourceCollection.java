package com.bookstore.api.resource;

import java.util.ArrayList;
import java.util.List;

import com.bookstore.api.response.BaseResponse;

public abstract class ResourceCollection<T extends ApiResource> extends BaseResponse {

	public List<T> resources=new ArrayList<T>();
}
