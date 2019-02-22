package com.bookstore.service.exception;

public class RecordNotFoundException extends RuntimeException {

	public RecordNotFoundException(String msj) {
		super(msj);
	}

}
