package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Orcamento;

public class OrcamentoDAO {

	public void salvar(Orcamento orcamento) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(orcamento);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public List<Orcamento> listar() {

		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from Orcamento");

		return query.getResultList();
	}

	public void remove(Orcamento orcamento) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();
		
		orcamento = entityManager.merge(orcamento);
		
		entityManager.remove(orcamento);

		entityManager.getTransaction().commit();

		entityManager.close();

	}

}
