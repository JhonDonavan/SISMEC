package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import model.Autorizacao;
import model.Usuario;
import modelDAO.AutorizacaoDAO;
import modelDAO.UsuarioDAO;

@ManagedBean
@SessionScoped
public class UsuarioController implements Serializable {

	@Autowired
	private List<Usuario> usuariosSelecionados;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private List<Autorizacao> autorizacoes;

	@Autowired
	private AutorizacaoDAO autorizacaoDAO;

	private static final long serialVersionUID = 1L;
	private Usuario usuario;

	public UsuarioController() {
		usuario = new Usuario();
		autorizacoes = new ArrayList<>();

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

	public List<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(List<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}
	
	public List<Usuario> getUsuariosSelecionados() {
		return usuariosSelecionados;
	}

	public void setUsuariosSelecionados(List<Usuario> usuariosSelecionados) {
		this.usuariosSelecionados = usuariosSelecionados;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public AutorizacaoDAO getAutorizacaoDAO() {
		return autorizacaoDAO;
	}

	public void setAutorizacaoDAO(AutorizacaoDAO autorizacaoDAO) {
		this.autorizacaoDAO = autorizacaoDAO;
	}

	public List<Usuario> listarPorNome(String nomeUsuario) {
		System.out.println("Entrou no metodo listarPorNome: " + nomeUsuario);
		try {
			System.out.println("ENTROU NO TRY");
			usuariosSelecionados = usuarioDAO.buscaUsuarioByNome(nomeUsuario);
		} catch (Exception e) {
			System.out.println("ERROR Exception: " + e);
		}
		System.out.println("Entrou no metodo listarPorNome: " + nomeUsuario + " E " + nomeUsuario);
		for (Usuario u : usuariosSelecionados) {
			System.out.println("Usuario: " + u.getNomeUsuario());
		}
		return usuariosSelecionados;
	}
	
	

}
