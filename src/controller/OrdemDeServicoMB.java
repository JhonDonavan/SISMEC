package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import model.Cliente;
import model.FormaPagamento;
import model.Funcionario;
import model.ItemServico;
import model.OrdemDeServico;
import model.Servico;
import model.StatusOrcamento;
import model.Veiculo;
import modelDAO.ClienteDAO;
import modelDAO.GenericDAO;
import modelDAO.MecanicoDAO;
import modelDAO.OrdemDeServicoDAO;
import modelDAO.VeiculoDAO;
import util.jsf.FacesUtil;

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
	
	private Cliente ClienteParaPlaca;
	
	private List<Veiculo> placas;

	private OrdemDeServico ordemDeServico = new OrdemDeServico();
	private List<OrdemDeServico> ordemDeServicos = new ArrayList<OrdemDeServico>();
	private String mensagemCadastroSucesso = "OrdemDeServico cadastrado com sucesso";
	private List<FormaPagamento> formaPagamento;
	private List<StatusOrcamento> status;

	private List<Servico> itens = new ArrayList<>();

	private Servico servicoLinhaEditavel;

	@PostConstruct
	public void init() {
		formaPagamento = Arrays.asList(FormaPagamento.values());
	}

	/* DATA ATUAL */
	String atual = dataAtual();

	public boolean exbirBotaoCancelarOS() {
		if (status.equals("EMITIDO") && status.equals("ORCAMENTO"))
			return true;
		else
			return false;
	}

	private String dataAtual() {
		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
		return (formatarDate.format(data));

	}

	public OrdemDeServicoMB() {
		ordemDeServicos = new GenericDAO<OrdemDeServico>(OrdemDeServico.class).listarTodos();
		ordemDeServico = new OrdemDeServico();
		ordemDeServicosSelecionados = new ArrayList<>();
	}

	public void cancelarStatus(OrdemDeServico ordemDeServico) {
		try {
			this.ordemDeServico = ordemDeServico;
			this.ordemDeServico.setStatus(StatusOrcamento.CANCELADO);
			new GenericDAO<OrdemDeServico>(OrdemDeServico.class).salvar(ordemDeServico);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Ordem De Servico cancelada com sucesso!"));
		} catch (Exception e) {

		}
	}

	public void finalizarStatus(OrdemDeServico ordemDeServico) {
		this.ordemDeServico = ordemDeServico;
		this.ordemDeServico.setStatus(StatusOrcamento.FINALIZADO);
		new GenericDAO<OrdemDeServico>(OrdemDeServico.class).salvar(ordemDeServico);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Ordem De Servico finalizada com sucesso!"));
	}

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			this.ordemDeServico.adicionarItemVazio();

			if (this.ordemDeServico != null) {
				this.recalculaOrdemDeServico();
			}
		}
	}

	public void recalculaOrdemDeServico() {
		if (this.ordemDeServico != null) {
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

	public void carregarServicoLinhaEditavel() {
		ItemServico item = this.ordemDeServico.getItemServico().get(0);

		if (this.servicoLinhaEditavel != null) {
			try {
				if (this.existeItemComServico(this.servicoLinhaEditavel)) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Aviso!", "Já existe um serviço igual neste item."));
				} else {
					item.setServico(this.servicoLinhaEditavel);
					item.setValorUnitario(this.servicoLinhaEditavel.getValor());

					this.ordemDeServico.adicionarItemVazio();
					this.servicoLinhaEditavel = null;

					this.ordemDeServico.recalcularValorTotal();
					
					
				}
			} catch (Exception e) {
			}
		}
	}

	private boolean existeItemComServico(Servico servico) {
		boolean existeItem = false;

		for (ItemServico item : this.getOrdemDeServico().getItemServico()) {

			if (servico.getId() == item.getServico().getId()) {
				existeItem = true;
				break;
			}
		}
		return existeItem;
	}
	
	public void carregarVeiculos(){
		ClienteParaPlaca = ordemDeServico.getCliente();
		System.out.println("chegou aqui" + ClienteParaPlaca.getNome());
	}
	
	public List<Veiculo> listarPorPlaca() {
		System.out.println("Entrou no metodo listarPorPlaca: " + ClienteParaPlaca.getNome());
		System.out.println(ClienteParaPlaca.getNome());
		try {
			System.out.println("ENTROU NO TRY");
			placas = VeiculoDAO.buscaVeiculoByPlaca(ClienteParaPlaca);
		} catch (Exception e) {
			System.out.println("ERROR Exception: " + e);
		}
		System.out.println("Entrou no metodo listarPorPlaca: " + ClienteParaPlaca.getNome() + " E " + ClienteParaPlaca.getNome());
		
		for (Veiculo v : placas) {
			System.out.println("Veiculo: " + v.getPlaca());
		}
		return placas;
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
		return "cadastrarOrdemDeServico.xhtml?faces-redirect=true";
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
		return "/ordemDeServico/cadastrarOrdemDeServico.xhtml?faces-redirect=true";
	}

	public List<Servico> completarServico(String nome) {
		return this.ordemDeServicoDAO.buscaServicoByNome(nome);
	}

	public void detalheOrdemDeServico(OrdemDeServico ordemDeServico) {
		this.ordemDeServico = ordemDeServico;
	}

	public List<Funcionario> completarMecanico(String nomeMecanico) {
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

	public List<StatusOrcamento> getStatus() {
		return status;
	}

	public void setStatus(List<StatusOrcamento> status) {
		this.status = status;
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

	public String getAtual() {
		return atual;
	}

	public void setAtual(String atual) {
		this.atual = atual;
	}

}
