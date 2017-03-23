package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import converter.ClienteConverter;
import model.Cliente;
import modelDAO.ClienteDAO;
import modelDAO.GenericDAO;

@ManagedBean(name = "clienteMB")
@SessionScoped
public class ClienteMB {

	@Autowired
	private List<Cliente> clientesSelecionados;
	
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private ClienteDAO clienteDAO = new ClienteDAO();

	public ClienteMB() {
		cliente = new Cliente();
		clientes = new GenericDAO<Cliente>(Cliente.class).listarTodos();
		clientesSelecionados = new ArrayList<>();
	}

	public String salvar() {
		new GenericDAO<Cliente>(Cliente.class).salvar(cliente);
		clientes = new GenericDAO<Cliente>(Cliente.class).listarTodos();
		cliente = new Cliente();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente cadastrado com sucesso"));
		System.out.println("Objeto " + cliente.getNome() + " cadastrado com sucesso!");
		return "listarClientes?faces-redirect=true";
	}
	
	public String editar(Cliente cliente){
		this.cliente = cliente;
		return "cadastrarCliente.xhtml?faces-redirect=true";
	}
	
	public void prepararExclusao(Cliente cliente){
		this.cliente = cliente;
		System.out.println(" preparar para excluir cliente: " + cliente.getNome());
	}
	
	public void excluir(){
		System.out.println("excluir cliente: " + cliente.getNome());
		new GenericDAO<Cliente>(Cliente.class).excluir(cliente);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cliente excluido com sucesso!"));
		clientes = new GenericDAO<Cliente>(Cliente.class).listarTodos();
	}
	
	public List<Cliente> listarPorNome(String nomeCliente){
		try {
			clientesSelecionados = clienteDAO.buscarClienteByNome(nomeCliente);
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
		}
		return clientesSelecionados;
		
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
