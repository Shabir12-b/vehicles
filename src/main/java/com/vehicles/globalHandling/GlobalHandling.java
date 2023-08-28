package com.vehicles.globalHandling;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vehicles.customException.BrandNotFoundException;
import com.vehicles.customException.IdNotFoundException;
import com.vehicles.customException.InvalidBoardException;

@RestControllerAdvice
public class GlobalHandling {
	
	@ExceptionHandler(BrandNotFoundException.class)
	public ResponseEntity<Object> brandHandler() {
		return new ResponseEntity<Object>("brand does not extist", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(InvalidBoardException.class)
	public ResponseEntity<Object> boardHandler() {
		return new ResponseEntity<Object>(" board does not exist", HttpStatus.BAD_GATEWAY);
	}

	  @ExceptionHandler(IdNotFoundException.class) 
	  public  ResponseEntity<Object> IdHandler() { 
	  return new ResponseEntity<Object>("Id not found", HttpStatus.BAD_GATEWAY); 
	  }
}
