package solution;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RegistrationFromTest
{
	@Test
	public void testAtLeastOneDigitRegExpForStringWithOneDigit()
	{
		String withOneDigit = "foo1bar";
		boolean actual = withOneDigit
			.matches(RegistrationForm.AT_LEAST_ONE_DIGIT);
		assertTrue(
			"pattern for 'at least one digit' is not working for a string with one digit",
			actual);
	}

	@Test
	public void testAtLeastOneDigitRegExpForStringWithNoDigits()
	{
		String withOneDigit = "foobar";
		boolean actual = withOneDigit
			.matches(RegistrationForm.AT_LEAST_ONE_DIGIT);
		assertFalse(
			"pattern for 'at least one digit' is not working for a string without digits",
			actual);
	}

	@Test
	public void testAtLeastOneDigitRegExpForEmptyString()
	{
		String withOneDigit = "";
		boolean actual = withOneDigit
			.matches(RegistrationForm.AT_LEAST_ONE_DIGIT);
		assertFalse(
			"pattern for 'at least one digit' is not working for an empty string",
			actual);
	}
}
