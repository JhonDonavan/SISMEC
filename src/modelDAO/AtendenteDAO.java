package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Atendente;

public class AtendenteDAO {
	
	@SuppressWarnings("unchecked")
	public List<Atendente> buscarAtendenteByNome(String nomeAtendente) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT c FROM Atendente c WHERE upper(c.nome) like upper(:nomeAtendente)");
		query.setParameter("nomeAtendente", "%" + nomeAtendente + "%");
		return query.getResultList();
	}

}
