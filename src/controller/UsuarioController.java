package controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;

	public UsuarioController() {
		usuario = new Usuario();
		
		SecurityContext context = SecurityContextHolder.getContext();
		if (context instanceof SecurityContext) {
			Authentication authentication = context.getAuthentication();
			if (authentication instanceof SecurityContext) {
				usuario.setNomeUsuario(((User) authentication.getPrincipal()).getUsername());
			}
		}
		
	}

	public Usuario getUsuario() {
		
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
