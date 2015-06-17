package solution;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import solution.model.User;

@Repository
@Transactional
public class Registration
{
	static final Logger logger = LoggerFactory.getLogger(Registration.class);

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PasswordEncoder encoder;

	public void register(String username, String password)
	{
		String encryptedPassword = encoder.encode(password);
		logger.debug("User persisted: {}", username);

		User user = new User(username, encryptedPassword);
		em.persist(user);
	}
}
