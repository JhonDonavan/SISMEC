package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import model.Orcamento;
import modelDAO.GenericDAO;
import modelDAO.OrcamentoDAO;

@ManagedBean(name = "Orcamento")
@SessionScoped
public class OrcamentoMB {

	@Autowired
	private List<Orcamento> orcamentosSelecionados;

	private OrcamentoDAO orcamentoDAO = new OrcamentoDAO();

	private Orcamento orcamento = new Orcamento();
	private List<Orcamento> orcamentos = new ArrayList<Orcamento>();
	private String mensagemCadastroSucesso = "Orcamento cadastrado com sucesso";

	public OrcamentoMB() {
		orcamentos = new GenericDAO<Orcamento>(Orcamento.class).listarTodos();
		orcamento = new Orcamento();
		orcamentosSelecionados = new ArrayList<>();
	}

	/* VERIFICAR COMO FAZER PARA LISTA CARREGAR AO INICIAR O SISTEMA */
	/*
	 * @SuppressWarnings("unused")
	 * 
	 * @PostConstruct public void init() { List<Orcamento> listaOrcamentos = new
	 * ArrayList<Orcamento>(); listaOrcamentos = new OrcamentoDAO().listar(); }
	 */

	public String salvar() {
		new GenericDAO<Orcamento>(Orcamento.class).salvar(orcamento);
		orcamento = new Orcamento();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Orcamento cadastrado com sucesso!"));
		orcamentos = new GenericDAO<Orcamento>(Orcamento.class).listarTodos();
		return "listarOrcamentos?faces-redirect=true";
	}

	public String editar(Orcamento orcamento) {
		this.orcamento = orcamento;
		return "cadastrarOrcamentos.xhtml?faces-redirect=true";
	}

	public void prepararExclusao(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public void excluir() {
		new GenericDAO<Orcamento>(Orcamento.class).excluir(orcamento);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Orcamento excluido com sucesso"));
		orcamentos = new GenericDAO<Orcamento>(Orcamento.class).listarTodos();
	}

	/*
	public List<Orcamento> listarPorNome(String nomeOrcamento) {
		System.out.println("Entrou no metodo listarPorNome: " + nomeOrcamento);
		try {
			System.out.println("ENTROU NO TRY");
			orcamentosSelecionados = orcamentoDAO.buscaOrcamentoByNome(nomeOrcamento);
		} catch (Exception e) {
			System.out.println("ERROR Exception: " + e);
		}
		System.out.println("Entrou no metodo listarPorNome: " + nomeOrcamento + " E " + nomeOrcamento);
		for (Orcamento m : orcamentosSelecionados) {
			System.out.println("Orcamento: " + m.getNome());
		}
		return orcamentosSelecionados;
	}*/

	public void limparOrcamento() {
		this.orcamento = new Orcamento();
	}
	
	public void detalheOrcamento(Orcamento orcamento){
		this.orcamento = orcamento;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public List<Orcamento> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public List<Orcamento> getOrcamentosSelecionados() {
		return orcamentosSelecionados;
	}

	public void setOrcamentosSelecionados(List<Orcamento> orcamentosSelecionados) {
		this.orcamentosSelecionados = orcamentosSelecionados;
	}

	public String getMensagemCadastroSucesso() {
		return mensagemCadastroSucesso;
	}

	public void setMensagemCadastroSucesso(String mensagemCadastroSucesso) {
		this.mensagemCadastroSucesso = mensagemCadastroSucesso;
	}

}
