package com.javax0.mezcla.assertions;

public class AssertException {
	private final Throwable throwable;

	private AssertException(Throwable throwable) {
		this.throwable = throwable;
	}

	public static AssertException assertException(Throwable throwable) {
		return new AssertException(throwable);
	}

	public AssertException is(Class<?> klass) throws Throwable {
		if (klass.isInstance(throwable)) {
			return this;
		}
		throw throwable;
	}

	public AssertException isOneOf(Class<?>... klasses) throws Throwable {
		for (Class<?> klass : klasses) {
			if (klass.isInstance(throwable)) {
				return this;
			}
		}
		throw throwable;
	}
}
