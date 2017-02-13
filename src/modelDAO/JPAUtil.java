package modelDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	public static EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("banco");
		
		EntityManager em = factory.createEntityManager();
		
		return em;
	}
}
