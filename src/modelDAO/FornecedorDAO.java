package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Fornecedor;

public class FornecedorDAO {
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> buscarFornecedorByNome(String nomeFornecedor) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT c FROM Fornecedor c WHERE upper(c.nome) like upper(:nomeFornecedor)");
		query.setParameter("nomeFornecedor", "%" + nomeFornecedor + "%");
		return query.getResultList();
	}

}
