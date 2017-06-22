package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Pagamento;

public class PagamentoDAO {

	public void salvar(Pagamento pagamento) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(pagamento);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public List<Pagamento> listar() {

		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from Pagamento");

		entityManager.close();
		return query.getResultList();
	}

	public void remove(Pagamento pagamento) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();
		
		pagamento = entityManager.merge(pagamento);
		
		entityManager.remove(pagamento);

		entityManager.getTransaction().commit();

		entityManager.close();

	}

}
