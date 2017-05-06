package modelDAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{

	
	//public Usuario usuarioPorEmail(String usuario) {
		
	
}



//seguir para login
//http://www.devmedia.com.br/java-web-criando-uma-tela-de-login-com-jpa-jsf-primefaces-e-mysql/32456