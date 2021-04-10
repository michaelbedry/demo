/**
 * NoSuchItemException -- exception that is throw when a select item is not found
 */
package com.atticsft.demomwi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoSuchItemException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NoSuchItemException(String message) {
		super(message);
	}
	
	public NoSuchItemException(String message, Throwable t) {
		super(message, t);
	}
}
