package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Autorizacao;

public class AutorizacaoDAO {

	@SuppressWarnings("unchecked")
	public List<Autorizacao> buscarPapeis(String nomePapel) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT a FROM Autorizacao a WHERE upper(a.nome) like upper(:nomePapel)");
		query.setParameter("nomePapel", "%" + nomePapel + "%");
		em.close();
		return query.getResultList();
	}
}
