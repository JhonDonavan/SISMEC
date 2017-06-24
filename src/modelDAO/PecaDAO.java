package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Peca;

public class PecaDAO {

	public void salvar(Peca peca) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(peca);

		entityManager.getTransaction().commit();

		entityManager.close();

	}

	@SuppressWarnings("unchecked")
	public List<Peca> listar() {

		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from Peca");

		entityManager.close();
		
		return query.getResultList();
	}


	@SuppressWarnings("unchecked")
	public List<Peca> buscaPecaByNome(String nomePeca) {
		System.out.println("entrou no metodo buscarPecaByNome na Peca: " + nomePeca);
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em
				.createQuery("SELECT m FROM Peca m WHERE upper(m.nome) like upper(:nomePeca)");
		query.setParameter("nomePeca", "%" + nomePeca + "%");
		
		
		return query.getResultList();

	}

	public void remove(Peca peca) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		peca = entityManager.merge(peca);

		entityManager.remove(peca);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

}
