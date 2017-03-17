package controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import model.Cliente;
import modelDAO.ClienteDAO;
import modelDAO.GenericDAO;

@ManagedBean (name = "Cliente")
@SessionScoped
public class ClienteController {
	
	@Autowired
	private List<Cliente> clientesSelecionados;
	
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private ClienteDAO clienteDAO = new ClienteDAO();
	
	public ClienteController() {
		clientes = new GenericDAO<Cliente>(Cliente.class).listarTodos();
		cliente = new Cliente();
		clientesSelecionados = new ArrayList<>();
	}
	
	public String salvar(){
		System.out.println("cliente no controller: " + cliente.getNome());
		new GenericDAO<Cliente>(Cliente.class).salvar(cliente);
		cliente = new Cliente();
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
		System.out.println("Cliente selecionado:  " + cliente.getNome() );
		return "cadastrarCliente?faces-redirect=true";
	}
	
	public List<Cliente> listarPorNome(String nomeCliente){
		try{
			clientesSelecionados = clienteDAO.buscarClienteByNome(nomeCliente);
		}catch(Exception e){
			System.out.println("ERROR Exception: " + e);
		}
		for(Cliente c : clientesSelecionados){
			System.out.println("Clientes: " + c.getNome());
		}
		return clientesSelecionados;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Cliente> getClientesSelecionados() {
		return clientesSelecionados;
	}

	public void setClientesSelecionados(List<Cliente> clientesSelecionados) {
		this.clientesSelecionados = clientesSelecionados;
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
