package de.awtools.schoolplanner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class ClassRepository {

	@PersistenceContext
	private EntityManager em;

	public Class findClass(long id) {
		return em.createQuery("select c from Class c", Class.class).getSingleResult();
	}

}
