package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Veiculo;

public class VeiculoDAO{

	public void salvar(Veiculo veiculo){
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(veiculo);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public List<Veiculo> listar() {
		
		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from Veiculo");
		
		return query.getResultList();
	}

}
