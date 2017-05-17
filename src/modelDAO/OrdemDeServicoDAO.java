package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.OrdemDeServico;
import model.Servico;

public class OrdemDeServicoDAO {

	public void salvar(OrdemDeServico ordemDeServico) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(ordemDeServico);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public List<OrdemDeServico> listar() {

		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from OrdemDeServico");

		return query.getResultList();
	}

	public void remove(OrdemDeServico ordemDeServico) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		ordemDeServico = entityManager.merge(ordemDeServico);

		entityManager.remove(ordemDeServico);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public List<Servico> buscaServicoByNome(String nomeServico) {
		System.out.println("entrou no metodo buscarServicoByNome na Servico: " + nomeServico);
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT m FROM Servico m WHERE upper(m.nome) like upper(:nomeServico)");
		query.setParameter("nomeServico", "%" + nomeServico + "%");
		return query.getResultList();
	}

}
