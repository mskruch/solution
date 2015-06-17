package solution;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegistrationForm
{
	@NotNull
	@Pattern(regexp = "^[\\pL\\pN]+$", message = "{validation.alphanumeric}")
	@Size(min = 5, message = "{validation.minLength}")
	private String username;
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
