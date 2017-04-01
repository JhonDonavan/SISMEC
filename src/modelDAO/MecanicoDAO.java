package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Mecanico;

public class MecanicoDAO {
	
	@SuppressWarnings("unchecked")
	public List<Mecanico> buscarMecanicoByNome(String nomeMecanico) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT c FROM Mecanico c WHERE upper(c.nome) like upper(:nomeMecanico)");
		query.setParameter("nomeMecanico", "%" + nomeMecanico + "%");
		return query.getResultList();
	}

}
