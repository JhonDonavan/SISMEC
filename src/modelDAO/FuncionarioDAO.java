package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Funcionario;

public class FuncionarioDAO {

	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarFuncionarioByNome(String nomeFuncionario) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT f FROM Funcionario f WHERE upper(f.nome) like upper(:nomeFuncionario)");
		query.setParameter("nomeFuncionario", "%" + nomeFuncionario + "%");
		em.close();
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarFuncionarioByNomeSemLogin(String nomeFuncionario) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em
				.createQuery("SELECT f FROM Funcionario f WHERE f.id not in (select u.funcionario from Usuario u)");
		em.close();
		return query.getResultList();
	}

}
