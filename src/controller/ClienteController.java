package controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.Cliente;
import modelDAO.GenericDAO;

@ManagedBean (name = "Cliente")
@SessionScoped
public class ClienteController {
	
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	public ClienteController() {
		clientes = new GenericDAO<Cliente>(Cliente.class).listarTodos();
		cliente = new Cliente();
	}
	
	public String salvar(){
		new GenericDAO<Cliente>(Cliente.class).salvar(cliente);
		clientes = new GenericDAO<Cliente>(Cliente.class).listarTodos();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente Cadastrado com Sucesso"));
		return "listarClientes?faces-redirect=true";
	}
	
	public void excluir(Cliente cliente){
		new GenericDAO<Cliente>(Cliente.class).excluir(cliente);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Cliente excluido com sucesso"));
		clientes = new GenericDAO<Cliente>(Cliente.class).listarTodos();
	}
	
	public String editar(Cliente cliente){
		this.cliente = cliente;
		return "cadastrarCliente?faces-redirect=true";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
