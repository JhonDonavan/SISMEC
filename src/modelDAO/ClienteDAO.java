package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Cliente;

public class ClienteDAO {

	@SuppressWarnings("unchecked")
	public List<Cliente> buscarClienteByNome(String nomeCliente) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT c FROM Cliente c WHERE upper(c.nome) like upper(:nomeCliente)");
		query.setParameter("nomeCliente", "%" + nomeCliente + "%");
		return query.getResultList();
	}

}
