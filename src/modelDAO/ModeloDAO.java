package modelDAO;

import javax.persistence.EntityManager;

import model.ModeloVeiculo;

public class ModeloDAO {
	public void salvar(ModeloVeiculo modelo){
		EntityManager entityMnager = JPAUtil.getEntityManager();
		
		entityMnager.getTransaction().begin();
		
		entityMnager.merge(modelo);
		
		entityMnager.getTransaction().commit();
		
		entityMnager.close();
	}
}
