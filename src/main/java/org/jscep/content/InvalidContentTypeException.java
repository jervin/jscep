package org.jscep.content;

import java.util.Arrays;

public class InvalidContentTypeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8144078591967730995L;

	public InvalidContentTypeException(String actual, String... expected) {
		this(String.format("Expected %s, but was %s", Arrays.toString(expected), actual));
	}
	
	public InvalidContentTypeException(Throwable cause) {
		super(cause);
	}
	
	public InvalidContentTypeException(String message) {
		super(message);
	}
}