package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import model.OrdemDeServico;
import modelDAO.GenericDAO;
import modelDAO.OrdemDeServicoDAO;

@ManagedBean(name = "OrdemDeServico")
@SessionScoped
public class OrdemDeServicoMB {

	@Autowired
	private List<OrdemDeServico> ordemDeServicosSelecionados;

	private OrdemDeServicoDAO ordemDeServicoDAO = new OrdemDeServicoDAO();

	private OrdemDeServico ordemDeServico = new OrdemDeServico();
	private List<OrdemDeServico> ordemDeServicos = new ArrayList<OrdemDeServico>();
	private String mensagemCadastroSucesso = "OrdemDeServico cadastrado com sucesso";

	public OrdemDeServicoMB() {
		ordemDeServicos = new GenericDAO<OrdemDeServico>(OrdemDeServico.class).listarTodos();
		ordemDeServico = new OrdemDeServico();
		ordemDeServicosSelecionados = new ArrayList<>();
	}

	/* VERIFICAR COMO FAZER PARA LISTA CARREGAR AO INICIAR O SISTEMA */
	/*
	 * @SuppressWarnings("unused")
	 * 
	 * @PostConstruct public void init() { List<OrdemDeServico> listaOrdemDeServicos = new
	 * ArrayList<OrdemDeServico>(); listaOrdemDeServicos = new OrdemDeServicoDAO().listar(); }
	 */

	public String salvar() {
		new GenericDAO<OrdemDeServico>(OrdemDeServico.class).salvar(ordemDeServico);
		ordemDeServico = new OrdemDeServico();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("OrdemDeServico cadastrado com sucesso!"));
		ordemDeServicos = new GenericDAO<OrdemDeServico>(OrdemDeServico.class).listarTodos();
		return "listarOrdemDeServicos?faces-redirect=true";
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

	/*
	public List<OrdemDeServico> listarPorNome(String nomeOrdemDeServico) {
		System.out.println("Entrou no metodo listarPorNome: " + nomeOrdemDeServico);
		try {
			System.out.println("ENTROU NO TRY");
			ordemDeServicosSelecionados = ordemDeServicoDAO.buscaOrdemDeServicoByNome(nomeOrdemDeServico);
		} catch (Exception e) {
			System.out.println("ERROR Exception: " + e);
		}
		System.out.println("Entrou no metodo listarPorNome: " + nomeOrdemDeServico + " E " + nomeOrdemDeServico);
		for (OrdemDeServico m : ordemDeServicosSelecionados) {
			System.out.println("OrdemDeServico: " + m.getNome());
		}
		return ordemDeServicosSelecionados;
	}*/

	public void limparOrdemDeServico() {
		this.ordemDeServico = new OrdemDeServico();
	}
	
	public void detalheOrdemDeServico(OrdemDeServico ordemDeServico){
		this.ordemDeServico = ordemDeServico;
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

}
