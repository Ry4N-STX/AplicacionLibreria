package ec.edu.ups.crud.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Resouerces {
	
	
	@Produces
	@PersistenceContext
	private EntityManager em;

	
}
