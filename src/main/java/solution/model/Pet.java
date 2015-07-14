package solution.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pet
{
	@Id
	private String id;
	@ManyToOne
	private User owner;
	private String name;

	Pet()
	{
		/* Required by Hibernate */
	}

	public Pet(String name)
	{
		this.id = UUID.randomUUID().toString();
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public User getOwner()
	{
		return owner;
	}

	void setOwner(User owner)
	{
		this.owner = owner;
	}

	@Override
	public String toString()
	{
		return "Pet [owner=" + owner + ", name=" + name + "]";
	}
}
