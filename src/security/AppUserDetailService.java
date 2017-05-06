package security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import model.Autorizacao;
import model.Usuario;
import modelDAO.GenericDAO;

public class AppUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = new GenericDAO<Usuario>(Usuario.class).opterPorUserName(username);
		UsuarioSistema user = null;
		
		if(usuario != null){
			user = new UsuarioSistema(usuario, getGrupos(usuario));
		}
		return user;
	}

	private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario) {
		List<SimpleGrantedAuthority> grupos = new ArrayList<>();
		
		for(Autorizacao grupo : usuario.getAutorizacoes()){
			grupos.add(new SimpleGrantedAuthority(grupo.getNome().toUpperCase()));
		}
		
		return grupos;
	}

}