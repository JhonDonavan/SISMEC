package modelDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Usuario;

public class UsuarioDAO {

	@SuppressWarnings("unchecked")
	public List<Usuario> buscaUsuarioByNome(String nomeUsuario) {
		System.out.println("entrou no metodo buscarUsuarioByNome no UsuarioDAO: " + nomeUsuario);
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT u FROM Usuarios u WHERE upper(u.nome) like upper(:nomeUsuario)");
		query.setParameter("nomeUsuario", "%" + nomeUsuario + "%");
		return query.getResultList();
	}

}
