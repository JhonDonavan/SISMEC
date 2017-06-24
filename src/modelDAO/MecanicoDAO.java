package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Funcionario;

public class MecanicoDAO {

	
	/*ESTE METODO DEVE SER ALOCADO EM FuncionarioDAO
	 * POREM POR FALTA DE TEMPO ESTÁ ALOCADO AQUI*/
	@SuppressWarnings("unchecked")
	public List<Funcionario> buscarMecanicoByNome(String nomeFuncionario) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT f FROM Funcionario f WHERE upper(f.nome) like upper(:nomeFuncionario) and f.cargo like :cargo");
		query.setParameter("nomeFuncionario", "%" + nomeFuncionario + "%");
		query.setParameter("cargo", "MECANICO");
		return query.getResultList();
	}

}
