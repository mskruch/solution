package solution;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegistrationForm
{
	static final String AT_LEAST_ONE_DIGIT = ".*\\d.*";
	static final String AT_LEAST_ONE_UPPERCASE = ".*\\p{Lu}.*";
	static final String AT_LEAST_ONE_LOWERCASE = ".*\\p{Ll}.*";

	@NotNull
	@Pattern(regexp = "^[\\pL\\pN]+$", message = "{validation.alphanumeric}")
	@Size(min = 5, message = "{validation.minLength}")
	private String username;

	@NotNull
	@Size(min = 8, message = "{validation.minLength}")
	@Pattern.List({
			@Pattern(regexp = AT_LEAST_ONE_DIGIT, message = "{validation.oneDigit}"),
			@Pattern(regexp = AT_LEAST_ONE_LOWERCASE, message = "{validation.oneLowercase}"),
			@Pattern(regexp = AT_LEAST_ONE_UPPERCASE, message = "{validation.oneUppercase}") })
	private String password;

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

}
