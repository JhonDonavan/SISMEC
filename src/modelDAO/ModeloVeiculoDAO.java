package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.ModeloVeiculo;

public class ModeloVeiculoDAO {
	public void salvar(ModeloVeiculo modelo) {
		EntityManager entityMnager = JPAUtil.getEntityManager();

		entityMnager.getTransaction().begin();

		entityMnager.merge(modelo);

		entityMnager.getTransaction().commit();

		entityMnager.close();
	}

	@SuppressWarnings("unchecked")
	public List<ModeloVeiculo> listar() {
		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from ModeloVeiculo");

		entityManager.close();
		return query.getResultList();
	}

	public void remove(ModeloVeiculo modelo) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		modelo = entityManager.merge(modelo);

		entityManager.remove(modelo);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	/*
	 * @SuppressWarnings("unchecked") public List<Montadora>
	 * buscaMontadoraByNome(String nomeMontadora) { EntityManager em =
	 * JPAUtil.getEntityManager(); Query query = em.createQuery(
	 * "SELECT * FROM Montadora"); query.setParameter("nomeMontadora", "%" +
	 * nomeMontadora + "%"); return query.getResultList(); }
	 */

	/*
	 * @SuppressWarnings("unchecked") public List<ModeloVeiculo>
	 * buscaModeloByNome(String nomeModelo) { EntityManager em =
	 * JPAUtil.getEntityManager(); Query query = em.createQuery(
	 * "SELECT * FROM modeloVeiculo"); query.setParameter("nomeModelo", "%" +
	 * nomeModelo + "%"); return query.getResultList(); }
	 */

	@SuppressWarnings("unchecked")
	public List<ModeloVeiculo> buscaModeloByNome(String nomeModelo) {
		System.out.println("entrou no metodo buscaModeloByNome no ModeloVeiculoDAO: " + nomeModelo);
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT mv FROM ModeloVeiculo mv WHERE upper(mv.nome) like upper(:nomeModelo)");
		query.setParameter("nomeModelo", "%" + nomeModelo + "%");
		em.close();
		return query.getResultList();
	}

}
