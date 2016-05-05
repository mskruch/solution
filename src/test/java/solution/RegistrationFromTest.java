package solution;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegistrationFromTest
{
	@Test
	public void testAtLeastOneDigitRegExpForStringWithOneDigit()
	{
		String foo = "foobar";
		boolean actual = foo.matches(RegistrationForm.AT_LEAST_ONE_DIGIT);
		assertTrue(
			"pattern for 'at least one digit' is not working for a string with one digit",
			actual);
	}

	@Test
	public void testAtLeastOneDigitRegExpForStringWithNoDigits()
	{
		String foo = "foobar";
		boolean actual = foo.matches(RegistrationForm.AT_LEAST_ONE_DIGIT);
		assertFalse(
			"pattern for 'at least one digit' is not working for a string without digits",
			actual);
	}

	@Test
	public void testAtLeastOneDigitRegExpForEmptyString()
	{
		String foo = "";
		boolean actual = foo.matches(RegistrationForm.AT_LEAST_ONE_DIGIT);
		assertFalse(
			"pattern for 'at least one digit' is not working for an empty string",
			actual);
	}

	@Test
	public void testAtLeastOneUppercaseRegExpForStringWithOneUppercase()
	{
		String foo = "fooBar";
		boolean actual = foo.matches(RegistrationForm.AT_LEAST_ONE_UPPERCASE);
		assertTrue(
			"pattern for 'at least one uppercase' is not working for a string with one uppercase",
			actual);
	}

	@Test
	public void testAtLeastOneUppercaseRegExpForStringWithNoUppercase()
	{
		String foo = "foobar";
		boolean actual = foo.matches(RegistrationForm.AT_LEAST_ONE_UPPERCASE);
		assertFalse(
			"pattern for 'at least one uppercase' is not working for a string with no uppercase",
			actual);
	}

	@Test
	public void testAtLeastOneUppercaseRegExpForEmptyString()
	{
		String foo = "";
		boolean actual = foo.matches(RegistrationForm.AT_LEAST_ONE_UPPERCASE);
		assertFalse(
			"pattern for 'at least one uppercase' is not working for an empty string",
			actual);
	}

	@Test
	public void testAtLeastOneLowercaseRegExpForStringWithOneLowercase()
	{
		String foo = "foobAR";
		boolean actual = foo.matches(RegistrationForm.AT_LEAST_ONE_LOWERCASE);
		assertTrue(
			"pattern for 'at least one lowercase' is not working for a string with one uppercase",
			actual);
	}

	@Test
	public void testAtLeastOneLowercaseRegExpForStringWithNoLowercase()
	{
		String foo = "FOOBAR";
		boolean actual = foo.matches(RegistrationForm.AT_LEAST_ONE_LOWERCASE);
		assertFalse(
			"pattern for 'at least one lowercase' is not working for a string with no lowercase",
			actual);
	}

	@Test
	public void testAtLeastOneLowercaseRegExpForEmptyString()
	{
		String foo = "";
		boolean actual = foo.matches(RegistrationForm.AT_LEAST_ONE_LOWERCASE);
		assertFalse(
			"pattern for 'at least one lowercase' is not working for an empty string",
			actual);
	}

}
