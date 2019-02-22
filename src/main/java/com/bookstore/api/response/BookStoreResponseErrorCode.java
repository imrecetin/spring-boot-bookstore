package com.bookstore.api.response;

public enum BookStoreResponseErrorCode {
	GENERAL_ERROR("99"),RUNTIME_ERROR("98"),NO_RECORD_FOUND("97");
    String code;
    
    BookStoreResponseErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
