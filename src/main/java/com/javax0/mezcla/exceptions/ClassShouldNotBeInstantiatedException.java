package com.javax0.mezcla.exceptions;

public class ClassShouldNotBeInstantiatedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ClassShouldNotBeInstantiatedException() {
		super();
	}

	public ClassShouldNotBeInstantiatedException(Class<?> klass) {
		super(klass.getCanonicalName());
	}

	public ClassShouldNotBeInstantiatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClassShouldNotBeInstantiatedException(String message) {
		super(message);
	}

	public ClassShouldNotBeInstantiatedException(Throwable cause) {
		super(cause);
	}

}
