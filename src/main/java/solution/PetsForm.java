package solution;

import javax.validation.constraints.NotNull;

public class PetsForm
{
	@NotNull
	private String username;
	@NotNull
	private String petName;

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPetName()
	{
		return petName;
	}

	public void setPetName(String petName)
	{
		this.petName = petName;
	}

}
