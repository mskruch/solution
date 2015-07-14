package solution;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import solution.exceptions.UserNotFound;
import solution.model.Pet;
import solution.model.User;

@Repository
@Transactional
public class Pets
{
	static final Logger logger = LoggerFactory.getLogger(Registration.class);

	@PersistenceContext
	private EntityManager em;

	public void addPet(String username, String petName)
	{
		User user = em.find(User.class, username);
		if (user == null) {
			throw new UserNotFound();
		}
		user.addPet(new Pet(petName));
		logger.info("Total number of pets: {}", user.getPets().size());
	}

}
