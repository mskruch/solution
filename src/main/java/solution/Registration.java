package solution;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import solution.exceptions.UserAlreadyRegistered;
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
		/*
		 * I know it was not required but I just can't store the password in
		 * plain text...
		 */
		String encryptedPassword = encoder.encode(password);
		logger.debug("User persisted: {}", username);

		User user = new User(username, encryptedPassword);
		em.persist(user);

		try {
			/* Manual flush only to catch the unique constraint exception */
			em.flush();
		} catch (PersistenceException e) {
			if (e.getCause() instanceof ConstraintViolationException) {
				/*
				 * There's only one unique constraint in this table so we can be
				 * sure
				 */
				throw new UserAlreadyRegistered(username);
			} else {
				throw e;
			}
		}
	}
}
