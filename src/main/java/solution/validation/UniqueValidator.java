package solution.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique, String>
{
	@PersistenceContext
	private EntityManager em;

	private Class<?> entity;
	private String attribute;

	@Override
	public void initialize(Unique constraintAnnotation)
	{
		attribute = constraintAnnotation.attribute();
		entity = constraintAnnotation.entity();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context)
	{
		Number count = (Number) em
			.createQuery(
				"select count(e) from " + entity.getSimpleName() + " e where "
					+ attribute + " = :value").setParameter("value", value)
			.getSingleResult();
		return count.intValue() == 0;
	}
}
