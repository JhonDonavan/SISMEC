package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import model.Mecanico;
import modelDAO.MecanicoDAO;
import modelDAO.GenericDAO;

@ManagedBean(name = "mecanicoMB")
@SessionScoped
public class MecanicoMB {
	
	@Autowired
	private List<Mecanico> mecanicosSelecionados;
	
	private Mecanico mecanico = new Mecanico();
	private List<Mecanico> mecanicos = new ArrayList<Mecanico>();
	private MecanicoDAO mecanicoDAO = new MecanicoDAO();

	public MecanicoMB() {
		mecanico = new Mecanico();
		mecanicos = new GenericDAO<Mecanico>(Mecanico.class).listarTodos();
		mecanicosSelecionados = new ArrayList<>();
	}

	public String salvar() {
		new GenericDAO<Mecanico>(Mecanico.class).salvar(mecanico);
		mecanicos = new GenericDAO<Mecanico>(Mecanico.class).listarTodos();
		mecanico = new Mecanico();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mecanico cadastrado com sucesso"));
		System.out.println("Objeto " + mecanico.getNome() + " cadastrado com sucesso!");
		return "listarMecanicos?faces-redirect=true";
	}
	
	public String editar(Mecanico mecanico){
		this.mecanico = mecanico;
		return "cadastrarMecanico.xhtml?faces-redirect=true";
	}
	
	public void prepararExclusao(Mecanico mecanico){
		this.mecanico = mecanico;
		System.out.println(" preparar para excluir mecanico: " + mecanico.getNome());
	}
	
	public void excluir(){
		System.out.println("excluir mecanico: " + mecanico.getNome());
		new GenericDAO<Mecanico>(Mecanico.class).excluir(mecanico);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Mecanico excluido com sucesso!"));
		mecanicos = new GenericDAO<Mecanico>(Mecanico.class).listarTodos();
	}
	
	public List<Mecanico> listarPorNome(String nomeMecanico){
		try {
			mecanicosSelecionados = mecanicoDAO.buscarMecanicoByNome(nomeMecanico);
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
		return mecanicosSelecionados;
	}
	
	public void limparMecanico(){
		this.mecanico = new Mecanico();
	}
	
	public void detalhesMecanico(Mecanico mecanico){
		this.mecanico = mecanico;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	public List<Mecanico> getMecanicos() {
		return mecanicos;
	}

	public void setMecanicos(List<Mecanico> mecanicos) {
		this.mecanicos = mecanicos;
	}

}
