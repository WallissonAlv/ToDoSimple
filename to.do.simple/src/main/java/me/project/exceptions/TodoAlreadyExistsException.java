package me.project.exceptions;

public class TodoAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TodoAlreadyExistsException(String message) {
		super(message);
	}
}
