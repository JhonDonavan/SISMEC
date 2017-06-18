package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import model.Cliente;
import model.Endereco;
import service.ServicoEndereco;

@ManagedBean(name ="CEPBean")
@SessionScoped
public class ControladorCEPBean implements Serializable{
	
private static final long serialVersionUID = -4818919924660193639L;
	
	private List<Endereco> listagem = new ArrayList<Endereco>();
	
	private Endereco endereco;
	
	private Cliente cliente;
	
	private String cep;

	private ServicoEndereco servico = new ServicoEndereco();

	public Endereco carregarEndereco() {
		endereco = new Endereco();
		cliente = new Cliente();
		Client c = Client.create();
		WebResource wr = c.resource("http://viacep.com.br/ws/" + this.getCep() + "/json/");
		System.out.println("CHAMOU O URI....");
		this.endereco = servico.buscarEnderecoPor(wr.get(String.class));
		String JSON = wr.get(String.class);
		System.out.println(JSON);
		cliente.setEndereco(this.endereco);
		return this.cliente.getEndereco();

	}

	public List<Endereco> getListagem() {
		return listagem;
	}

	public void setListagem(List<Endereco> listagem) {
		this.listagem = listagem;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void limpar() {
		this.endereco = new Endereco();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
