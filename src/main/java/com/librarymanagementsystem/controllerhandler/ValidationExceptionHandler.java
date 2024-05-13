package com.librarymanagementsystem.controllerhandler;

import com.librarymanagementsystem.exception.*;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestControllerAdvice
public class ValidationExceptionHandler
{

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex)
	{
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return ResponseEntity.badRequest().body(errors);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<Map<String, String>> handleEntityNotFoundException(EntityNotFoundException ex)
	{
		return ResponseEntity.badRequest().body(ex.toMap());
	}

	@ExceptionHandler(RuntimeBusinessException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<Map<String, String>> handleEntityNotFoundException(RuntimeBusinessException ex)
	{
		return ResponseEntity.badRequest().body(ex.toMap());
	}
}