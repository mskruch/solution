package solution.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User
{
	@Id
	private String username;
	private String password;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	public Collection<Pet> pets = new ArrayList<Pet>();

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

	public Collection<Pet> getPets()
	{
		return Collections.unmodifiableCollection(pets);
	}

	public void addPet(Pet pet)
	{
		this.pets.add(pet);
		pet.setOwner(this);
	}
}
