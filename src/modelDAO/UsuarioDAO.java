package modelDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer>{

}
