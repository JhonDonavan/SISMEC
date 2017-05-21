package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.ItemServico;

public class ItemServicoDAO {
	
	public void salvar(ItemServico ItemServico) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(ItemServico);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public List<ItemServico> listar() {

		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from ItemServico");

		return query.getResultList();
	}

	public void remove(ItemServico ItemServico) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();
		
		ItemServico = entityManager.merge(ItemServico);
		
		entityManager.remove(ItemServico);

		entityManager.getTransaction().commit();

		entityManager.close();

	}

}
