package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Montadora;

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


	@SuppressWarnings("unchecked")
	public List<Montadora> buscaMontadoraByNome(String nomeMontadora) {
		System.out.println("entrou no metodo buscarMontadoraByNome no ModeloVeiculoDAO: " + nomeMontadora);
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em
				.createQuery("SELECT m FROM Montadora m WHERE upper(m.nome) like upper(:nomeMontadora)");
		query.setParameter("nomeMontadora", "%" + nomeMontadora + "%");

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
