package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import model.Cliente;
import model.FormaPagamento;
import model.ItemServico;
import model.Mecanico;
import model.OrdemDeServico;
import model.Servico;
import model.Veiculo;
import modelDAO.ClienteDAO;
import modelDAO.GenericDAO;
import modelDAO.MecanicoDAO;
import modelDAO.OrdemDeServicoDAO;
import modelDAO.ServicoDAO;
import modelDAO.VeiculoDAO;
import util.jsf.FacesUtil;

@Named
@ManagedBean(name = "ordemDeServicoMB")
@SessionScoped
public class OrdemDeServicoMB {

	@Autowired
	private List<OrdemDeServico> ordemDeServicosSelecionados;
	@Autowired
	private MecanicoDAO mecanicos;
	@Autowired
	private VeiculoDAO veiculos;
	@Autowired
	private ClienteDAO clientes;

	private OrdemDeServicoDAO ordemDeServicoDAO = new OrdemDeServicoDAO();

	private OrdemDeServico ordemDeServico = new OrdemDeServico();
	private List<OrdemDeServico> ordemDeServicos = new ArrayList<OrdemDeServico>();
	private String mensagemCadastroSucesso = "OrdemDeServico cadastrado com sucesso";
	private List<FormaPagamento> formaPagamento;

	private List<Servico> itens = new ArrayList<>();

	private Servico servicoLinhaEditavel;
	
	@PostConstruct
	public void init() {
		formaPagamento = Arrays.asList(FormaPagamento.values());
	}
	
	public OrdemDeServicoMB() {
		ordemDeServicos = new GenericDAO<OrdemDeServico>(OrdemDeServico.class).listarTodos();
		ordemDeServico = new OrdemDeServico();
		ordemDeServicosSelecionados = new ArrayList<>();
	}
	
	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			this.ordemDeServico.adicionarItemVazio();
			
			if(this.ordemDeServico != null){
				this.recalculaOrdemDeServico();
			}
		}
	}

	public void recalculaOrdemDeServico(){
		System.out.println("ENTROU NO METODO RECALCULAR ORDEM DE SERVICO");
		if(this.ordemDeServico != null){
			this.ordemDeServico.recalcularValorTotal();
		}
	}
	
	public void atualizarQuantidade(ItemServico item, int linha) {
		if (item.getQuantidade() < 1) {
			if (linha == 0) {
				item.setQuantidade(1);
			} else {
				this.getOrdemDeServico().getItemServico().remove(linha);
			}
		}
		
		this.ordemDeServico.recalcularValorTotal();
	}
	
	public void carregarServicoLinhaEditavel(){
		System.out.println("Entrou no método carregarLinhaDigitavel");
		
		ItemServico item = this.ordemDeServico.getItemServico().get(0);
		
		if(this.servicoLinhaEditavel != null){
			System.out.println("entrou no IF dentro do carregarServicoLinhaEditavel");
			item.setServico(this.servicoLinhaEditavel);
			item.setValorUnitario(this.servicoLinhaEditavel.getValor());
			
			System.out.println(item.getServico().getNome());
			
			this.ordemDeServico.adicionarItemVazio();
			this.servicoLinhaEditavel = null;
			
			this.ordemDeServico.recalcularValorTotal();
		}
	}
	
	public String salvar() {
		this.ordemDeServico.removerItemVazio();
		new GenericDAO<OrdemDeServico>(OrdemDeServico.class).salvar(ordemDeServico);
		ordemDeServico = new OrdemDeServico();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("OrdemDeServico cadastrado com sucesso!"));
		ordemDeServicos = new GenericDAO<OrdemDeServico>(OrdemDeServico.class).listarTodos();
		return "listarOrdemDeServicos.xhtml?faces-redirect=true";
	}

	public String editar(OrdemDeServico ordemDeServico) {
		this.ordemDeServico = ordemDeServico;
		return "cadastrarOrdemDeServicos.xhtml?faces-redirect=true";
	}

	public void prepararExclusao(OrdemDeServico ordemDeServico) {
		this.ordemDeServico = ordemDeServico;
	}

	public void excluir() {
		new GenericDAO<OrdemDeServico>(OrdemDeServico.class).excluir(ordemDeServico);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("OrdemDeServico excluido com sucesso"));
		ordemDeServicos = new GenericDAO<OrdemDeServico>(OrdemDeServico.class).listarTodos();
	}

	public String limparOrdemDeServico() {
		this.ordemDeServico = new OrdemDeServico();
		return "cadastrarOrdemDeServico.xhtml?faces-redirect=true";
	}
	
	
	public List<Servico> completarServico(String nome){
		return this.ordemDeServicoDAO.buscaServicoByNome(nome);
	}

	public void detalheOrdemDeServico(OrdemDeServico ordemDeServico) {
		this.ordemDeServico = ordemDeServico;
	}

	public List<Mecanico> completarMecanico(String nomeMecanico) {
		return this.mecanicos.buscarMecanicoByNome(nomeMecanico);
	}

	@SuppressWarnings("static-access")
	public List<Veiculo> completarVeiculo(String placa) {
		return this.veiculos.buscaVeiculoByPlaca(placa);
	}

	public List<Cliente> completarCliente(String nome) {
		return this.clientes.buscarClienteByNome(nome);
	}

	public OrdemDeServico getOrdemDeServico() {
		return ordemDeServico;
	}

	public void setOrdemDeServico(OrdemDeServico ordemDeServico) {
		this.ordemDeServico = ordemDeServico;
	}

	public List<OrdemDeServico> getOrdemDeServicos() {
		return ordemDeServicos;
	}

	public void setOrdemDeServicos(List<OrdemDeServico> ordemDeServicos) {
		this.ordemDeServicos = ordemDeServicos;
	}

	public List<OrdemDeServico> getOrdemDeServicosSelecionados() {
		return ordemDeServicosSelecionados;
	}

	public void setOrdemDeServicosSelecionados(List<OrdemDeServico> ordemDeServicosSelecionados) {
		this.ordemDeServicosSelecionados = ordemDeServicosSelecionados;
	}

	public String getMensagemCadastroSucesso() {
		return mensagemCadastroSucesso;
	}

	public void setMensagemCadastroSucesso(String mensagemCadastroSucesso) {
		this.mensagemCadastroSucesso = mensagemCadastroSucesso;
	}

	public List<FormaPagamento> getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(ArrayList<FormaPagamento> formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public List<Servico> getItens() {
		return itens;
	}

	public void setItens(List<Servico> itens) {
		this.itens = itens;
	}

	public Servico getServicoLinhaEditavel() {
		return servicoLinhaEditavel;
	}

	public void setServicoLinhaEditavel(Servico servicoLinhaEditavel) {
		this.servicoLinhaEditavel = servicoLinhaEditavel;
	}
}
