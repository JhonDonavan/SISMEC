package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Servico;

public class ServicoDAO {

	public void salvar(Servico servico) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(servico);

		entityManager.getTransaction().commit();

		entityManager.close();

	}

	@SuppressWarnings("unchecked")
	public List<Servico> listar() {

		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from Servico");

		return query.getResultList();
	}


	@SuppressWarnings("unchecked")
	public List<Servico> buscaServicoByNome(String nomeServico) {
		System.out.println("entrou no metodo buscarServicoByNome na Servico: " + nomeServico);
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em
				.createQuery("SELECT m FROM Servico m WHERE upper(m.nome) like upper(:nomeServico)");
		query.setParameter("nomeServico", "%" + nomeServico + "%");
		return query.getResultList();
	}

	public void remove(Servico servico) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		servico = entityManager.merge(servico);

		entityManager.remove(servico);

		entityManager.getTransaction().commit();

		entityManager.close();
	}


}
