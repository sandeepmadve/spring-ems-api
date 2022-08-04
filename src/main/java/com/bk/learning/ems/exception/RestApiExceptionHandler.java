package com.bk.learning.ems.exception;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex){

		ApiError apiError = new ApiError
				.ApiErrorBuilder(HttpStatus.NOT_FOUND, ex.getMessage(), ex)
				.build();

		return buildResponseEntity(apiError);

	}

	@Override
//	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){

		List<FieldError> fieldErros = ex.getBindingResult().getFieldErrors();
		List<ApiSubError> apiSubErrors = fieldErros.stream()
				.map(error -> new ApiValidationError(error.getObjectName(), error.getField(), error.getRejectedValue(), error.getDefaultMessage()))
				.collect(Collectors.toList());

		ApiError apiError = new ApiError
				.ApiErrorBuilder(HttpStatus.BAD_REQUEST, ex.getMessage(), ex)
				.setSubErrors(apiSubErrors)
				.build();
		
		return buildResponseEntity(apiError);
		
	}
	

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError){
		return new ResponseEntity<Object>(apiError, apiError.getStatus());
	}
}
