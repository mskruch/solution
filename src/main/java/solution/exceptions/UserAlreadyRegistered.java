package solution.exceptions;

@SuppressWarnings("serial")
public class UserAlreadyRegistered extends RuntimeException
{
	private String username;

	public UserAlreadyRegistered(String username)
	{
		this.username = username;
	}

	public String getUsername()
	{
		return username;
	}
}
