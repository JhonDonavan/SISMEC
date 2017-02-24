package modelDAO;

import javax.persistence.EntityManager;

import model.Montadora;

public class MontadoraDAO {

	public void salvar(Montadora montadora) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(montadora);

		entityManager.getTransaction().commit();

		entityManager.close();

	}

}
