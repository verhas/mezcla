package com.javax0.mezcla.assertions;

import static com.javax0.mezcla.assertions.TestException.exception;

/**
 * This utility class along with {@link TestException} can mimic the Java 7
 * multiple exception catch in Java 6 or lower environment. When different
 * exceptions are thrown then the structure:
 * 
 * <pre>
 * try {
 *   code that throws some exception
 * }catch(Exception e){
 *   assertException(e).isOneOf( list of exception classes to be caught );
 *   handling the exception
 * }
 * </pre>
 * 
 * When the assertion is called then if the exception is none of the listed
 * exceptions then this is rethrown like if it was never caught.
 * 
 * You can also separate the handling of the different types of exceptions using
 * the pattern:
 * 
 * <pre>
 *  ...
 * catch(Exception e){
 *   assertException(e).isOneOf( list of exception classes to be caught );
 *   if( exception(e).is(handledExceptionType) ){
 *    ...
 *   }else if( exception(e).is(otherExceptionType) ){
 *    ...
 *   } else 
 *   ...
 * }
 * </pre>
 * 
 * Note that the above sample code structures assume that
 * {@link TestException#exception(Throwable)} and/or
 * {@link #assertException(Throwable)} are imported static to the code.
 * 
 * @author Peter Verhas
 * 
 */
public class AssertException {
	private final Throwable throwable;

	private AssertException(Throwable throwable) {
		this.throwable = throwable;
	}

	/**
	 * Returns a new instance of this class that can be used to test the
	 * exception using one of the methods {@link #is(Class)} and
	 * {@link #isOneOf(Class...)}.
	 */
	public static AssertException assertException(Throwable throwable) {
		return new AssertException(throwable);
	}

	/**
	 * Checks that the exception is the type {@code klass} and if it is not then
	 * throws the exception.
	 */
	public void is(Class<?> klass) throws Throwable {
		if (exception(throwable).is(klass)) {
			return;
		}
		throw throwable;
	}

	/**
	 * Checks that the exception type is one of the {@code klasses} and if not
	 * then throws the exception.
	 * 
	 * @param klasses
	 * @throws Throwable
	 */
	public void isOneOf(Class<?>... klasses) throws Throwable {
		if (exception(throwable).isOneOf(klasses)) {
			return;
		}
		throw throwable;
	}
}
