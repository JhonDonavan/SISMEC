package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import model.Fornecedor;
import modelDAO.FornecedorDAO;
import modelDAO.GenericDAO;

@ManagedBean(name = "fornecedorMB")
@SessionScoped
public class FornecedorMB {
	
	@Autowired
	private List<Fornecedor> fornecedorsSelecionados;
	
	private Fornecedor fornecedor = new Fornecedor();
	private List<Fornecedor> fornecedors = new ArrayList<Fornecedor>();
	private FornecedorDAO fornecedorDAO = new FornecedorDAO();

	public FornecedorMB() {
		fornecedor = new Fornecedor();
		fornecedors = new GenericDAO<Fornecedor>(Fornecedor.class).listarTodos();
		fornecedorsSelecionados = new ArrayList<>();
	}

	public String salvar() {
		new GenericDAO<Fornecedor>(Fornecedor.class).salvar(fornecedor);
		fornecedors = new GenericDAO<Fornecedor>(Fornecedor.class).listarTodos();
		fornecedor = new Fornecedor();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fornecedor cadastrado com sucesso"));
		System.out.println("Objeto " + fornecedor.getNome() + " cadastrado com sucesso!");
		return "listarFornecedors?faces-redirect=true";
	}
	
	public String editar(Fornecedor fornecedor){
		this.fornecedor = fornecedor;
		return "cadastrarFornecedor.xhtml?faces-redirect=true";
	}
	
	public void prepararExclusao(Fornecedor fornecedor){
		this.fornecedor = fornecedor;
		System.out.println(" preparar para excluir fornecedor: " + fornecedor.getNome());
	}
	
	public void excluir(){
		System.out.println("excluir fornecedor: " + fornecedor.getNome());
		new GenericDAO<Fornecedor>(Fornecedor.class).excluir(fornecedor);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fornecedor excluido com sucesso!"));
		fornecedors = new GenericDAO<Fornecedor>(Fornecedor.class).listarTodos();
	}
	
	public List<Fornecedor> listarPorNome(String nomeFornecedor){
		try {
			fornecedorsSelecionados = fornecedorDAO.buscarFornecedorByNome(nomeFornecedor);
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
		return fornecedorsSelecionados;
	}
	
	public void limparFornecedor(){
		this.fornecedor = new Fornecedor();
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedors() {
		return fornecedors;
	}

	public void setFornecedors(List<Fornecedor> fornecedors) {
		this.fornecedors = fornecedors;
	}

}
