package security;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import model.Autorizacao;

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

	public String getAutorizacao() {
		String autorizacao = null;

		List<Autorizacao> autorizacaoes = null;

		UsuarioSistema usuariologado = getUsuarioLogado();

		if (usuariologado != null) {
			autorizacaoes = usuariologado.getUsuario().getAutorizacoes();
		}
		for (Autorizacao user : autorizacaoes) {
			autorizacao = user.getNome();
		}
		return autorizacao;
	}

	private UsuarioSistema getUsuarioLogado() {
		UsuarioSistema usuario = null;

		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) FacesContext
				.getCurrentInstance().getExternalContext().getUserPrincipal();

		if (auth != null && auth.getPrincipal() != null) {
			usuario = (UsuarioSistema) auth.getPrincipal();
		}

		return usuario;
	}

}
