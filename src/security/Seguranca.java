package security;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@ManagedBean
public class Seguranca {

	public String getNomeUsuario() {
		String nome = null;

		UsuarioSistema usuariologado = getUsuarioLogado();

		if (usuariologado != null) {
			nome = usuariologado.getUsuario().getNomeUsuario();
		}
		return nome;
	}

	private UsuarioSistema getUsuarioLogado() {
		UsuarioSistema usuario = null;

		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) FacesContext
				.getCurrentInstance().getExternalContext().getUserPrincipal();
	
		if(auth != null && auth.getPrincipal() != null){
			usuario = (UsuarioSistema) auth.getPrincipal();
		}
		
		return usuario;
	}

}
