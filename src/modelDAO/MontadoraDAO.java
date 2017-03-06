package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import model.Montadora;

public class MontadoraDAO {

	public void salvar(Montadora montadora) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(montadora);

		entityManager.getTransaction().commit();

		entityManager.close();

	}

	@SuppressWarnings("unchecked")
	public List<Montadora> listar() {

		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from Montadora");

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Montadora> procurarPorNome(String nome) {
		Session session = JPAUtil.getEntityManager().unwrap(Session.class);
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Montadora.class);
		if (StringUtils.isNotBlank(nome)) {
			criteria.add(Restrictions.ilike("nome", nome.toUpperCase(), MatchMode.START));
		}
		return criteria.list();

		/*
		 * EntityManager entityManager = JPAUtil.getEntityManager(); Query query
		 * = entityManager.createQuery("from Montadora where nome like" + nome +
		 * "%"); return query.getResultList();
		 */

	}

	@SuppressWarnings("unchecked")
	public List<Montadora> buscaMontadoraByNome(String nomeMontadora) {
		System.out.println("entrou no metodo buscarMontadoraByNome no ModeloVeiculoDAO: " + nomeMontadora);
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em
				.createQuery("SELECT m FROM Montadora m WHERE upper(m.nome) like upper(:nomeMontadora)");
		query.setParameter("nomeMontadora", "%" + nomeMontadora + "%");

		return query.getResultList();

	}

	public void remove(Montadora montadora) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		montadora = entityManager.merge(montadora);

		entityManager.remove(montadora);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

}
