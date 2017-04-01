package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import model.Atendente;
import modelDAO.AtendenteDAO;
import modelDAO.GenericDAO;

@ManagedBean(name = "atendenteMB")
@SessionScoped
public class AtendenteMB {
	
	@Autowired
	private List<Atendente> atendentesSelecionados;
	
	private Atendente atendente = new Atendente();
	private List<Atendente> atendentes = new ArrayList<Atendente>();
	private AtendenteDAO atendenteDAO = new AtendenteDAO();

	public AtendenteMB() {
		atendente = new Atendente();
		atendentes = new GenericDAO<Atendente>(Atendente.class).listarTodos();
		atendentesSelecionados = new ArrayList<>();
	}

	public String salvar() {
		new GenericDAO<Atendente>(Atendente.class).salvar(atendente);
		atendentes = new GenericDAO<Atendente>(Atendente.class).listarTodos();
		atendente = new Atendente();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atendente cadastrado com sucesso"));
		System.out.println("Objeto " + atendente.getNome() + " cadastrado com sucesso!");
		return "listarAtendentes?faces-redirect=true";
	}
	
	public String editar(Atendente atendente){
		this.atendente = atendente;
		return "cadastrarAtendente.xhtml?faces-redirect=true";
	}
	
	public void prepararExclusao(Atendente atendente){
		this.atendente = atendente;
		System.out.println(" preparar para excluir atendente: " + atendente.getNome());
	}
	
	public void excluir(){
		System.out.println("excluir atendente: " + atendente.getNome());
		new GenericDAO<Atendente>(Atendente.class).excluir(atendente);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atendente excluido com sucesso!"));
		atendentes = new GenericDAO<Atendente>(Atendente.class).listarTodos();
	}
	
	public List<Atendente> listarPorNome(String nomeAtendente){
		try {
			atendentesSelecionados = atendenteDAO.buscarAtendenteByNome(nomeAtendente);
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
		return atendentesSelecionados;
	}
	
	public void limparAtendente(){
		this.atendente = new Atendente();
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public List<Atendente> getAtendentes() {
		return atendentes;
	}

	public void setAtendentes(List<Atendente> atendentes) {
		this.atendentes = atendentes;
	}

}
