package com.javax0.mezcla.assertions;

import org.junit.Test;
import static com.javax0.mezcla.assertions.AssertException.*;

@SuppressWarnings("serial")
public class AssertExceptionTest {

	@Test
	public void given_Exception_when_AssertingTheExceptionWithTheSameType_then_ExceptionIsAsserted()
			throws Throwable {
		Exception exception = new Exception();
		assertException(exception).is(Exception.class);
	}

	@Test(expected = Exception.class)
	public void given_Exception_when_AssertingTheExceptionWithTheSubType_then_ExceptionIsThrown()
			throws Throwable {
		Exception exception = new Exception();
		assertException(exception).is(new Exception() {
		}.getClass());
	}

	@Test
	public void given_ExceptionSubType_when_AssertingTheExceptionTypes_then_ExceptionIsAsserted()
			throws Throwable {
		Exception exception = new Exception() {
		};
		assertException(exception).isOneOf(RuntimeException.class,Exception.class);
	}

	@Test(expected = Exception.class)
	public void given_Exception_when_AssertingTheExceptionWithManySubType_then_ExceptionIsThrown()
			throws Throwable {
		Exception exception = new Exception();
		assertException(exception).isOneOf(new Exception() {
		}.getClass(), new Exception() {
		}.getClass());
	}

	@Test
	public void given_ExceptionSubType_when_AssertingTheExceptionType_then_ExceptionIsAsserted()
			throws Throwable {
		Exception exception = new Exception() {
		};
		assertException(exception).is(Exception.class);
	}
}
