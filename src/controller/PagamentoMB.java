package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import model.Pagamento;
import modelDAO.GenericDAO;
import modelDAO.PagamentoDAO;

@ManagedBean(name = "pagamentoMB")
@SessionScoped
public class PagamentoMB {

	@Autowired
	private List<Pagamento> pagamentosSelecionados;

	private PagamentoDAO pagamentoDAO = new PagamentoDAO();

	private Pagamento pagamento = new Pagamento();
	private List<Pagamento> pagamentos = new ArrayList<Pagamento>();
	private String mensagemCadastroSucesso = "Pagamento cadastrado com sucesso";

	public PagamentoMB() {
		pagamentos = new GenericDAO<Pagamento>(Pagamento.class).listarTodos();
		pagamento = new Pagamento();
		pagamentosSelecionados = new ArrayList<>();
	}

	/* VERIFICAR COMO FAZER PARA LISTA CARREGAR AO INICIAR O SISTEMA */
	/*
	 * @SuppressWarnings("unused")
	 * 
	 * @PostConstruct public void init() { List<Pagamento> listaPagamentos = new
	 * ArrayList<Pagamento>(); listaPagamentos = new PagamentoDAO().listar(); }
	 */

	public String salvar() {
		new GenericDAO<Pagamento>(Pagamento.class).salvar(pagamento);
		pagamento = new Pagamento();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pagamento cadastrado com sucesso!"));
		pagamentos = new GenericDAO<Pagamento>(Pagamento.class).listarTodos();
		return "listarPagamentos?faces-redirect=true";
	}

	public String editar(Pagamento pagamento) {
		this.pagamento = pagamento;
		return "cadastrarPagamentos.xhtml?faces-redirect=true";
	}

	public void prepararExclusao(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public void excluir() {
		new GenericDAO<Pagamento>(Pagamento.class).excluir(pagamento);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pagamento excluido com sucesso"));
		pagamentos = new GenericDAO<Pagamento>(Pagamento.class).listarTodos();
	}

	/*
	public List<Pagamento> listarPorNome(String nomePagamento) {
		System.out.println("Entrou no metodo listarPorNome: " + nomePagamento);
		try {
			System.out.println("ENTROU NO TRY");
			pagamentosSelecionados = pagamentoDAO.buscaPagamentoByNome(nomePagamento);
		} catch (Exception e) {
			System.out.println("ERROR Exception: " + e);
		}
		System.out.println("Entrou no metodo listarPorNome: " + nomePagamento + " E " + nomePagamento);
		for (Pagamento m : pagamentosSelecionados) {
			System.out.println("Pagamento: " + m.getNome());
		}
		return pagamentosSelecionados;
	}*/

	public String limparPagamento() {
		this.pagamento = new Pagamento();
		return "cadastrarPagamentos.xhtml?faces-redirect=true";
	}
	
	public void detalhePagamento(Pagamento pagamento){
		this.pagamento = pagamento;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public List<Pagamento> getPagamentosSelecionados() {
		return pagamentosSelecionados;
	}

	public void setPagamentosSelecionados(List<Pagamento> pagamentosSelecionados) {
		this.pagamentosSelecionados = pagamentosSelecionados;
	}

	public String getMensagemCadastroSucesso() {
		return mensagemCadastroSucesso;
	}

	public void setMensagemCadastroSucesso(String mensagemCadastroSucesso) {
		this.mensagemCadastroSucesso = mensagemCadastroSucesso;
	}

}
