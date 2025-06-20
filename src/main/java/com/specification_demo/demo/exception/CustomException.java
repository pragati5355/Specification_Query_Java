package com.specification_demo.demo.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	/**
	 * Http status
	 */
	private final HttpStatus httpStatus;
	private Exception exception;
	private String code;

	/**
	 * Detailed error message
	 */
	private final String detail;

	/**
	 * Constructs new custom exception with message, error description and http
	 * status
	 * 
	 * @author Mindbowser | rohit.kavthekar@mindbowser.com
	 * @param message
	 * @param detail
	 * @param httpStatus
	 */
	public CustomException(String message, Exception e, String code, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
		this.exception = e;
		this.code = code;
		this.detail = null;
	}

	/**
	 * Constructs new custom exception with message and http status
	 * 
	 * @author Mindbowser | rohit.kavthekar@mindbowser.com
	 * @param message
	 * @param httpStatus
	 */
	public CustomException(String message, String code, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
		this.code = code;
		this.detail = null;
	}

	/**
	 * Constructs new custom exception with message. Default status to internal
	 * server error
	 * 
	 * @author Mindbowser | rohit.kavthekar@mindbowser.com
	 * @param message
	 */
	public CustomException(String message) {
		super(message);
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.detail = null;
	}

	/**
	 * Constructs new custom exception with message. Default status to internal
	 * server error
	 * 
	 * @author Mindbowser | rohit.kavthekar@mindbowser.com
	 * @param message
	 */
	public CustomException(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
		this.detail = null;
	}

	/**
	 * Constructs new custom exception with message and error description. Default
	 * status to internal server error
	 * 
	 * @author Mindbowser | rohit.kavthekar@mindbowser.com
	 * @param message
	 * @param detail
	 */
	public CustomException(String message, String detail) {
		super(message);
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.detail = detail;
	}

	/**
	 * Constructs new custom exception with message and http status
	 * 
	 * @author Mindbowser | rohit.kavthekar@mindbowser.com
	 * @param message
	 * @param httpStatus
	 */
	public CustomException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
		this.detail = null;
	}

	public CustomException(String string, Exception exception) {
		super(string);
		this.exception = exception;
		this.detail = null;
		this.httpStatus = null;
	}
    
}
