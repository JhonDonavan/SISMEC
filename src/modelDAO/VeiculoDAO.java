package modelDAO;

import javax.persistence.EntityManager;

import model.Veiculo;

public class VeiculoDAO{

	public void salvar(Veiculo veiculo){
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(veiculo);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

}
