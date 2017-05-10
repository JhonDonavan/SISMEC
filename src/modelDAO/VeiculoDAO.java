package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.ModeloVeiculo;
import model.Veiculo;

public class VeiculoDAO {

	public void salvar(Veiculo veiculo) {
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

	public void remove(Veiculo veiculo) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();
		
		veiculo = entityManager.merge(veiculo);
		
		entityManager.remove(veiculo);

		entityManager.getTransaction().commit();

		entityManager.close();

	}
	
	@SuppressWarnings("unchecked")
	public static List<Veiculo> buscaVeiculoByPlaca(String placa) {
		System.out.println("entrou no metodo buscaVeiculoByPlaca no VeiculoDAO: " + placa);
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT v FROM Veiculo v WHERE upper(v.placa) like upper(:placa)");
		query.setParameter("placa", "%" + placa + "%");
		return query.getResultList();
	}

}
