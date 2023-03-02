package com.koushik.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.koushik.blog.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// dont know how but the following function gets called when there is resourcenotfound exception
	// and giving custom message, 
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler( ResourceNotFoundException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
}
