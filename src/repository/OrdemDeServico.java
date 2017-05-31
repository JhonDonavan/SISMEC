package repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import filter.OrdemDeServicoFilter;
import modelDAO.JPAUtil;

public class OrdemDeServico implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	EntityManager manager = JPAUtil.getEntityManager();

	@SuppressWarnings("unchecked")
	public List<OrdemDeServico> filtrados(OrdemDeServicoFilter filtro) {
		Session session = this.manager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(OrdemDeServico.class)
				// fazemos uma associação (join) com cliente e nomeamos como "c"
				.createAlias("cliente", "c")
				// fazemos uma associação (join) com mecanico e nomeamos como "v"
				.createAlias("mecanico", "v");
		
		if (filtro.getNumeroDe() != null) {
			// id deve ser maior ou igual (ge = greater or equals) a filtro.numeroDe
			criteria.add(Restrictions.ge("id", filtro.getNumeroDe()));
		}

		if (filtro.getNumeroAte() != null) {
			// id deve ser menor ou igual (le = lower or equal) a filtro.numeroDe
			criteria.add(Restrictions.le("id", filtro.getNumeroAte()));
		}

		if (filtro.getDataCriacaoDe() != null) {
			criteria.add(Restrictions.ge("dataCriacao", filtro.getDataCriacaoDe()));
		}
		
		if (filtro.getDataCriacaoAte() != null) {
			criteria.add(Restrictions.le("dataCriacao", filtro.getDataCriacaoAte()));
		}
		
		if (StringUtils.isNotBlank(filtro.getNomeCliente())) {
			// acessamos o nome do cliente associado ao ordemDeServico pelo alias "c", criado anteriormente
			criteria.add(Restrictions.ilike("c.nome", filtro.getNomeCliente(), MatchMode.ANYWHERE));
		}
		
		if (StringUtils.isNotBlank(filtro.getNomeMecanico())) {
			// acessamos o nome do mecanico associado ao ordemDeServico pelo alias "v", criado anteriormente
			criteria.add(Restrictions.ilike("v.nome", filtro.getNomeMecanico(), MatchMode.ANYWHERE));
		}
		
		if (filtro.getStatuses() != null && filtro.getStatuses().length > 0) {
			// adicionamos uma restrição "in", passando um array de constantes da enum StatusOrdemDeServico
			criteria.add(Restrictions.in("status", filtro.getStatuses()));
		}
		
		return criteria.addOrder(Order.asc("id")).list();
	}

}
