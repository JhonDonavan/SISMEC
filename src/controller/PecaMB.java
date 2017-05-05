package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import model.Peca;
import modelDAO.GenericDAO;
import modelDAO.PecaDAO;

@ManagedBean(name = "pecasMB")
@SessionScoped
public class PecaMB {

	@Autowired
	private List<Peca> pecasSelecionados;

	private PecaDAO pecaDAO = new PecaDAO();

	private Peca peca = new Peca();
	private List<Peca> pecas = new ArrayList<Peca>();
	private String mensagemCadastroSucesso = "Peca cadastrado com sucesso";

	public PecaMB() {
		pecas = new GenericDAO<Peca>(Peca.class).listarTodos();
		peca = new Peca();
		pecasSelecionados = new ArrayList<>();
	}

	/* VERIFICAR COMO FAZER PARA LISTA CARREGAR AO INICIAR O SISTEMA */
	/*
	 * @SuppressWarnings("unused")
	 * 
	 * @PostConstruct public void init() { List<Peca> listaPecas = new
	 * ArrayList<Peca>(); listaPecas = new PecaDAO().listar(); }
	 */

	public String salvar() {
		new GenericDAO<Peca>(Peca.class).salvar(peca);
		peca = new Peca();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Peca cadastrada com sucesso!"));
		pecas = new GenericDAO<Peca>(Peca.class).listarTodos();
		return "listarPecas?faces-redirect=true";
	}

	public String editar(Peca peca) {
		this.peca = peca;
		return "cadastrarPecas.xhtml?faces-redirect=true";
	}

	public void prepararExclusao(Peca peca) {
		this.peca = peca;
	}

	public void excluir() {
		new GenericDAO<Peca>(Peca.class).excluir(peca);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Peca excluido com sucesso"));
		pecas = new GenericDAO<Peca>(Peca.class).listarTodos();
	}

	public List<Peca> listarPorNome(String nomePeca) {
		System.out.println("Entrou no metodo listarPorNome: " + nomePeca);
		try {
			System.out.println("ENTROU NO TRY");
			pecasSelecionados = pecaDAO.buscaPecaByNome(nomePeca);
		} catch (Exception e) {
			System.out.println("ERROR Exception: " + e);
		}
		System.out.println("Entrou no metodo listarPorNome: " + nomePeca + " E " + nomePeca);
		for (Peca m : pecasSelecionados) {
			System.out.println("Peca: " + m.getNome());
		}
		return pecasSelecionados;
	}

	public String limparPeca() {
		this.peca = new Peca();
		return "cadastrarPecas.xhtml?faces-redirect=true";
	}
	
	public void detalhePeca(Peca peca){
		this.peca = peca;
	}

	public Peca getPeca() {
		return peca;
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
	}

	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}

	public List<Peca> getPecasSelecionados() {
		return pecasSelecionados;
	}

	public void setPecasSelecionados(List<Peca> pecasSelecionados) {
		this.pecasSelecionados = pecasSelecionados;
	}

	public String getMensagemCadastroSucesso() {
		return mensagemCadastroSucesso;
	}

	public void setMensagemCadastroSucesso(String mensagemCadastroSucesso) {
		this.mensagemCadastroSucesso = mensagemCadastroSucesso;
	}

}
