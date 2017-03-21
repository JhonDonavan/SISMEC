package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Cliente;
import modelDAO.GenericDAO;

@ManagedBean(name="clienteMB")
@SessionScoped
public class ClienteMB {
	
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	public ClienteMB(){
		cliente = new Cliente();
		clientes = new GenericDAO<Cliente>(Cliente.class).listarTodos();
	}
	
	
	public String salvar(){
		new GenericDAO<Cliente>(Cliente.class).salvar(cliente);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Cliente cadastrado com sucesso"));
		System.out.println("Objeto " + cliente.getNome() + " cadastrado com sucesso!");
		clientes = new GenericDAO<Cliente>(Cliente.class).listarTodos();
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
