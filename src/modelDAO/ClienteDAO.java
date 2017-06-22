package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Cliente;
import model.Veiculo;

public class ClienteDAO {

	@SuppressWarnings("unchecked")
	public List<Cliente> buscarClienteByNome(String nomeCliente) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT c FROM Cliente c WHERE upper(c.nome) like upper(:nomeCliente)");
		query.setParameter("nomeCliente", "%" + nomeCliente + "%");
		System.out.println("entrou no metodo buscarClienteByNome no DAO");
		em.close();
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Veiculo> buscaVeiculoCliente(String veiculo) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("FROM Cliente cliente " +
                      "LEFT JOIN FETCH cliente.veiculo");
		em.close();
		return query.getResultList();
				
	}
}
