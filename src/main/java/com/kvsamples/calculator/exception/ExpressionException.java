package com.kvsamples.calculator.exception;

/**
 * Base class for the Exceptions
 * 
 * @author Vimalraj Kanagaraj
 *
 */
public class ExpressionException extends RuntimeException {
	private static final long serialVersionUID = -6407590306056392088L;

	/**
	 * ExpressionException constructor
	 * 
	 * @param message
	 *            exception message to be thrown
	 */
	public ExpressionException(String message) {
		super(message);
	}
}
