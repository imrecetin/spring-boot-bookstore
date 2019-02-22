package com.bookstore.api.controller.advise;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.bookstore.api.response.BaseResponse;
import com.bookstore.api.response.BookStoreResponseErrorCode;
import com.bookstore.service.exception.RecordNotFoundException;

@ControllerAdvice
@SuppressWarnings("unchecked")
public class BookStoreExceptionAdvisor {

	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request){
		BaseResponse error=new BaseResponse(BookStoreResponseErrorCode.GENERAL_ERROR.getCode(),ExceptionUtils.getMessage(ex));
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<Object> handleSanalPosDecoderException(Exception ex, WebRequest request){
		BaseResponse error=new BaseResponse(BookStoreResponseErrorCode.RUNTIME_ERROR.getCode(),ExceptionUtils.getMessage(ex));
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
