package com.bk.learning.ems.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

/**
 * Using Builder Design Pattern
 * @author Saideep
 *
 */
@Getter
public class ApiError{
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private HttpStatus status;
	private String message;
	private String debugMessage;
	private List<ApiSubError> subErrors;
	
	private ApiError(ApiErrorBuilder builder){
		this.timestamp = LocalDateTime.now();
		this.status = builder.status;
		this.message = builder.message;
		this.debugMessage = builder.debugMessage;
	}
	
	//Builder class
	public static class ApiErrorBuilder{
		
		//Mandatory fields
		private HttpStatus status;
		private String message;
		private String debugMessage;
		//Optional field
		private List<ApiSubError> subErrors;
		
		//Constructor for mandatory fields
		public ApiErrorBuilder(HttpStatus status, String message, Throwable ex){
			this.status = status;
			this.message = message;
			this.debugMessage = ex.getLocalizedMessage();
		}
		
		//Setter for optional field
		public ApiErrorBuilder setSubErrors(List<ApiSubError> subErrors) {
			this.subErrors = subErrors;
			return this;
		}
		
		// Build method
		public ApiError build() {
			return new ApiError(this);
		}
	}
	
	
}