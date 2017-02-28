package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Montadora;
import model.Veiculo;

public class MontadoraDAO {

	public void salvar(Montadora montadora) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(montadora);

		entityManager.getTransaction().commit();

		entityManager.close();

	}

	@SuppressWarnings("unchecked")
	public List<Montadora> listar() {

		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from Montadora");

		return query.getResultList();
	}

	public void remove(Montadora montadora) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		montadora = entityManager.merge(montadora);

		entityManager.remove(montadora);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

}
