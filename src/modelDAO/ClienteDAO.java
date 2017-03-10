package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Cliente;

public class ClienteDAO {
	
	public void salvar(Cliente cliente) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(cliente);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listar() {

		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from Cliente");

		return query.getResultList();
	}

	public void remove(Cliente cliente) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();
		
		cliente = entityManager.merge(cliente);
		
		entityManager.remove(cliente);

		entityManager.getTransaction().commit();

		entityManager.close();

	}

}
