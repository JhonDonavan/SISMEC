package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Funcionario;

public class FuncionarioDAO {
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarFuncionarioByNome(String nomeFuncionario) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT c FROM Funcionario c WHERE upper(c.nome) like upper(:nomeFuncionario)");
		query.setParameter("nomeFuncionario", "%" + nomeFuncionario + "%");
		return query.getResultList();
	}

}
