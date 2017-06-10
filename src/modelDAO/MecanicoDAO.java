package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Funcionario;

public class MecanicoDAO {

	
	/*ESTE MÉTODO DEVE SER ALOCADO NO DAO FuncionarioDAO
	 * POR FALTA DE TEMPO, FOI ALOCADO AQUI*/
	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarMecanicoByNome(String nomeFuncionario) {
		EntityManager em = JPAUtil.getEntityManager();
		
		System.out.println(nomeFuncionario);
		
		Query query = em.createQuery("SELECT f FROM Funcionario f WHERE upper(f.nome) like upper(:nomeFuncionario)");
		query.setParameter("nomeFuncionario", "%" + nomeFuncionario + "%");
		return query.getResultList();
	}

}
