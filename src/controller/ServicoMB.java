package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import model.Servico;
import modelDAO.GenericDAO;
import modelDAO.ServicoDAO;

@ManagedBean(name = "Servico")
@SessionScoped
public class ServicoMB {

	@Autowired
	private List<Servico> servicosSelecionados;

	private ServicoDAO servicoDAO = new ServicoDAO();

	private Servico servico = new Servico();
	private List<Servico> servicos = new ArrayList<Servico>();
	private String mensagemCadastroSucesso = "Servico cadastrado com sucesso";

	public ServicoMB() {
		servicos = new GenericDAO<Servico>(Servico.class).listarTodos();
		servico = new Servico();
		servicosSelecionados = new ArrayList<>();
	}

	/* VERIFICAR COMO FAZER PARA LISTA CARREGAR AO INICIAR O SISTEMA */
	/*
	 * @SuppressWarnings("unused")
	 * 
	 * @PostConstruct public void init() { List<Servico> listaServicos = new
	 * ArrayList<Servico>(); listaServicos = new ServicoDAO().listar(); }
	 */

	public String salvar() {
		new GenericDAO<Servico>(Servico.class).salvar(servico);
		servico = new Servico();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Servico cadastrada com sucesso!"));
		servicos = new GenericDAO<Servico>(Servico.class).listarTodos();
		return "listarServicos?faces-redirect=true";
	}

	public String editar(Servico servico) {
		this.servico = servico;
		return "cadastrarServicos.xhtml?faces-redirect=true";
	}

	public void prepararExclusao(Servico servico) {
		this.servico = servico;
	}

	public void excluir() {
		new GenericDAO<Servico>(Servico.class).excluir(servico);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Servico excluido com sucesso"));
		servicos = new GenericDAO<Servico>(Servico.class).listarTodos();
	}

	public List<Servico> listarPorNome(String nomeServico) {
		System.out.println("Entrou no metodo listarPorNome: " + nomeServico);
		try {
			System.out.println("ENTROU NO TRY");
			servicosSelecionados = servicoDAO.buscaServicoByNome(nomeServico);
		} catch (Exception e) {
			System.out.println("ERROR Exception: " + e);
		}
		System.out.println("Entrou no metodo listarPorNome: " + nomeServico + " E " + nomeServico);
		for (Servico m : servicosSelecionados) {
			System.out.println("Servico: " + m.getNome());
		}
		return servicosSelecionados;
	}

	public void limparServico() {
		this.servico = new Servico();
	}
	
	public void detalheServico(Servico servico){
		this.servico = servico;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public List<Servico> getServicosSelecionados() {
		return servicosSelecionados;
	}

	public void setServicosSelecionados(List<Servico> servicosSelecionados) {
		this.servicosSelecionados = servicosSelecionados;
	}

	public String getMensagemCadastroSucesso() {
		return mensagemCadastroSucesso;
	}

	public void setMensagemCadastroSucesso(String mensagemCadastroSucesso) {
		this.mensagemCadastroSucesso = mensagemCadastroSucesso;
	}

}
