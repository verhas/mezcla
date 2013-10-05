package com.javax0.mezcla.assertions;

/**
 * Class to test exceptions. The patterns how to use this class is documented in
 * the class {@link AssertException}.
 * 
 * @author Peter Verhas
 * 
 */
public class TestException {
	private final Throwable throwable;

	private TestException(Throwable throwable) {
		this.throwable = throwable;
	}

	/**
	 * Returns a new instance of this class that can be used to test the
	 * exception using one of the methods {@link #is(Class)} and
	 * {@link #isOneOf(Class...)}.
	 * 
	 * @param throwable
	 * @return
	 */
	public static TestException exception(Throwable throwable) {
		return new TestException(throwable);
	}

	/**
	 * Returns true if the exception is the type specified in the argument.
	 * 
	 */
	public boolean is(Class<?> klass) {
		return klass.isInstance(throwable);
	}

	/**
	 * Returns true if the exception is one of the classes listed as argument.
	 * 
	 * @param klasses
	 * @return
	 */
	public boolean isOneOf(Class<?>... klasses) {
		for (Class<?> klass : klasses) {
			if (is(klass)) {
				return true;
			}
		}
		return false;
	}
}
