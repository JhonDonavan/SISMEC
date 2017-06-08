package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import model.Funcionario;
import modelDAO.FuncionarioDAO;
import modelDAO.GenericDAO;

@SuppressWarnings("serial")
@ManagedBean(name = "funcionarioMB")
@SessionScoped
public class FuncionarioMB implements Serializable{
	
	@Autowired
	private List<Funcionario> funcionariosSelecionados;
	
	private Funcionario funcionario = new Funcionario();
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

	public FuncionarioMB() {
		funcionario = new Funcionario();
		funcionarios = new GenericDAO<Funcionario>(Funcionario.class).listarTodos();
		funcionariosSelecionados = new ArrayList<>();
	}

	public String salvar() {
		new GenericDAO<Funcionario>(Funcionario.class).salvar(funcionario);
		funcionarios = new GenericDAO<Funcionario>(Funcionario.class).listarTodos();
		funcionario = new Funcionario();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atendente cadastrado com sucesso"));
		System.out.println("Objeto " + funcionario.getNome() + " cadastrado com sucesso!");
		return "listarFuncionarios.xhtml?faces-redirect=true";
	}
	
	public String editar(Funcionario funcionario){
		this.funcionario = funcionario;
		return "cadastrarFuncionario.xhtml?faces-redirect=true";
	}
	
	public void prepararExclusao(Funcionario funcionario){
		this.funcionario = funcionario;
		System.out.println(" preparar para excluir funcionario: " + funcionario.getNome());
	}
	
	public void excluir(){
		System.out.println("excluir funcionario: " + funcionario.getNome());
		new GenericDAO<Funcionario>(Funcionario.class).excluir(funcionario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Funcionario excluido com sucesso!"));
		funcionarios = new GenericDAO<Funcionario>(Funcionario.class).listarTodos();
	}
	
	public List<Funcionario> listarPorNome(String nomeFuncionario){
		try {
			funcionariosSelecionados = funcionarioDAO.buscarFuncionarioByNome(nomeFuncionario);
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
		return funcionariosSelecionados;
	}
	
	public String limparFuncionario(){
		this.funcionario = new Funcionario();
		return "cadastrarFuncionario.xhtml?faces-redirect=true";
	}
	
	public void detalhesFuncionario(Funcionario funcionario){
		this.funcionario = funcionario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
