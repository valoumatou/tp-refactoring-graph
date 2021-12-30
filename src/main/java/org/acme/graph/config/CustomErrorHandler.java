package org.acme.graph.config;

import org.acme.graph.errors.JsonError;
import org.acme.graph.errors.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * [spring] Rendu des exceptions au format JSON
 *
 * @author mborne
 */
@ControllerAdvice
public class CustomErrorHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<JsonError> handleExceptions(Exception e, WebRequest request) {
		JsonError error = new JsonError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<JsonError> handleNotFoundExceptions(Exception e, WebRequest request) {
		JsonError error = new JsonError(HttpStatus.NOT_FOUND, e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
