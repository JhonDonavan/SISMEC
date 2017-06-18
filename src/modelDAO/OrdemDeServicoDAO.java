package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Cliente;
import model.OrdemDeServico;
import model.Servico;
import model.Veiculo;

public class OrdemDeServicoDAO {

	public void salvar(OrdemDeServico ordemDeServico) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(ordemDeServico);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public List<OrdemDeServico> listar() {

		EntityManager entityManager = JPAUtil.getEntityManager();

		Query query = entityManager.createQuery("from OrdemDeServico");

		return query.getResultList();
	}

	public void remove(OrdemDeServico ordemDeServico) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		ordemDeServico = entityManager.merge(ordemDeServico);

		entityManager.remove(ordemDeServico);

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public List<Servico> buscaServicoByNome(String nomeServico) {
		System.out.println("entrou no metodo buscarServicoByNome na Servico: " + nomeServico);
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT m FROM Servico m WHERE upper(m.nome) like upper(:nomeServico)");
		query.setParameter("nomeServico", "%" + nomeServico + "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Veiculo> buscaVeiculoCliente(Cliente cliente) {
		System.out.println(cliente.getNome());
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("select v from Veiculo v inner join Cliente c on c.id = v.cliente where c.nome like upper(:nomeCliente)");
    	query.setParameter("nomeCliente", "%" + cliente.getNome() + "%");
		return query.getResultList();
		
	}
	
	
//	Query query = em.createQuery("select v from Veiculo v join Cliente c on c.id = v.cliente_id where c.nome like (:nomeCliente)");
//	query.setParameter("nomeFuncionario", "%" + cliente.getNome() + "%");
	
	//Query query = em.createQuery("SELECT v FROM Veiculo v WHERE v.cliente_id in(select c.veiculo from Cliente c)");
}
