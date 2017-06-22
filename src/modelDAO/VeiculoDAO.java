package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Cliente;
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

		entityManager.close();
		
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
	public static List<Veiculo> buscaVeiculoByPlaca(Cliente cliente) {
		System.out.println("entrou no metodo buscaVeiculoByPlaca no VeiculoDAO: " + cliente.getNome());
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("select v from Veiculo v inner join Cliente c on c.id = v.cliente where c.id = :idCliente");
    	query.setParameter("idCliente", cliente.getId());
    	em.close();
		return query.getResultList();
		
		/*Query query = em.createQuery("select v from Veiculo v inner join Cliente c on c.id = v.cliente where c.nome like upper(:nomeCliente)");
    	query.setParameter("nomeCliente", "%" + cliente.getNome() + "%");*/
	}

	@SuppressWarnings("unchecked")
	public static List<Veiculo> buscaVeiculoByPlaca(String placa) {
		System.out.println("entrou no metodo buscaVeiculoByPlaca no VeiculoDAO: " + placa);
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT v FROM Veiculo v WHERE upper(v.placa) like upper(:placa)");
		query.setParameter("placa", "%" + placa + "%");
		em.close();
		return query.getResultList();
	}

}
