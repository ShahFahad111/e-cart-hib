package com.map.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.map.util.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<ApiResponse> itemNotFoundException(ItemNotFoundException ex){
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setErrorMessage(ex.getMessage());
		apiResponse.setStatus(false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CartNotFoundException.class)
	public ResponseEntity<ApiResponse> cartNotFoundException(CartNotFoundException ex){
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setErrorMessage(ex.getMessage());
		apiResponse.setStatus(false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
}
