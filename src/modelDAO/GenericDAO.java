package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericDAO<T> {

	private final Class<T> classe;

	public GenericDAO(Class<T> classe) {
		this.classe = classe;
	}

	public void salvar(T t) {
		EntityManager em = JPAUtil.getEntityManager();

		System.out.println("Objeto salvo com sucesso: " + t.getClass().getName());

		em.getTransaction().begin();

		em.merge(t);

		em.getTransaction().commit();

		em.close();
	}

	public void excluir(T t) {
		System.out.println("5");
		EntityManager em = JPAUtil.getEntityManager();
		System.out.println("6");
		em.getTransaction().begin();
		System.out.println("7");
		T t2 = em.merge(t);
		System.out.println("8");
		
		try {
			em.remove(t2);
			System.out.println(t2.getClass().getName());
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
		System.out.println("9");
		em.getTransaction().commit();
		System.out.println("10");
		em.close();

	}

	public List<T> listarTodos() {
		EntityManager em = JPAUtil.getEntityManager();

		List<T> resultado = em.createQuery("from " + classe.getName(), classe).getResultList();

		em.close();

		return resultado;
	}

	public T obterPorId(Integer id) {
		EntityManager em = JPAUtil.getEntityManager();
		T t = em.createQuery("from " + classe.getName() + " where id = :cod", classe).setParameter("cod", id)
				.getSingleResult();
		em.close();
		return t;
	}
}
