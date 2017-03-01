package com.csci3130.a3.email;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class EmailValidatorTest {

	private EmailValidation validator;

	@Before
	public void setup() {
		validator = EmailValidator.getInstance();
	}

	@Test
	public void testNotEmail() {
		assertEquals(2, validator.validate("google.com"));
	}

	@Test
	public void testSimpleEmailValid() {
		assertEquals(3, validator.validate("mine-fds.123_egewfdsh@example.cs.com"));
	}

	@Test
	public void testComplexEmailInvalid() {
		assertEquals(3, validator.validate("mine-fds.123_egew+fdsh@dal.ca"));
	}

	@Test
	public void testDupAt() {
		assertEquals(2, validator.validate("something.r@gm@dal.ca"));
	}

	@Test
	public void testInvalidEmail() {
		assertEquals(1, validator.validate("-"));
	}

	@Test
	public void testEmpty() {
		assertEquals(0, validator.validate(""));
	}
}
