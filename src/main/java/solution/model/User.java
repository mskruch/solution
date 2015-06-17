package solution.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User
{
	@Id
	private String username;
	private String password;

	User()
	{
		/* Required by Hibernate */
	}

	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	public String getPassword()
	{
		return password;
	}

	public String getUsername()
	{
		return username;
	}

	@Override
	public String toString()
	{
		return "User " + username;
	}

}
