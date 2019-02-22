package com.bookstore.api.response;

import com.bookstore.api.resource.ApiResource;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public  class BaseResponse extends ApiResource{
	public String errorMessage;
	public String errorCode;
	public Long responseId;
	
	public BaseResponse(BaseResponseBuilder builder) {
		this.errorCode=builder.errorCode;
		this.errorMessage=builder.errorMessage;
		this.responseId=builder.responseId;
	}
	
	public BaseResponse() {}
	
	public BaseResponse(String code, String message) {
		this.errorCode=code;
		this.errorMessage=message;
	}

	public static class BaseResponseBuilder{
		private String errorMessage;
		private String errorCode;
		private Long responseId;
		
		public BaseResponse build() {
			return new BaseResponse(this);
		}
		
		public BaseResponseBuilder responseId(Long responseId) {
			this.responseId=responseId;
			return this;
		}
		
		public BaseResponseBuilder errorCode(String errorCode) {
			this.errorCode=errorCode;
			return this;
		}
		
		public BaseResponseBuilder errorMessage(String errorMessage) {
			this.errorMessage=errorMessage;
			return this;
		}
		
	}
	
	public static BaseResponseBuilder baseBuilder(){
		return new BaseResponseBuilder();
	}

}
