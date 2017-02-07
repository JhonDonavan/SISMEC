package modelDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{

}



//seguir para login
//http://www.devmedia.com.br/java-web-criando-uma-tela-de-login-com-jpa-jsf-primefaces-e-mysql/32456