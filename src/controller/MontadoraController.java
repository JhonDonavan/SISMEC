package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import model.Montadora;
import modelDAO.GenericDAO;
import modelDAO.MontadoraDAO;

@ManagedBean(name = "montadoraMB")
@SessionScoped
public class MontadoraController {

	@Autowired
	private List<Montadora> montadorasSelecionados;

	private MontadoraDAO montadoraDAO = new MontadoraDAO();

	private Montadora montadora = new Montadora();
	private List<Montadora> montadoras = new ArrayList<Montadora>();
	private String mensagemCadastroSucesso = "Montadora cadastrado com sucesso";

	public MontadoraController() {
		montadoras = new GenericDAO<Montadora>(Montadora.class).listarTodos();
		montadora = new Montadora();
		montadorasSelecionados = new ArrayList<>();
	}

	public String salvar() {
		new GenericDAO<Montadora>(Montadora.class).salvar(montadora);
		montadora = new Montadora();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Montadora cadastrada com sucesso!"));
		
		montadoras = new GenericDAO<Montadora>(Montadora.class).listarTodos();
		return "listarMontadoras?faces-redirect=true";
	}
	
	public String cancelar(){
		return "listarMontadoras?faces-redirect=true";
	}

	public String editar(Montadora montadora) {
		this.montadora = montadora;
		return "cadastrarMontadoras.xhtml?faces-redirect=true";
	}

	public void prepararExclusao(Montadora montadora) {
		this.montadora = montadora;
	}

	public void excluir() {
		new GenericDAO<Montadora>(Montadora.class).excluir(montadora);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Montadora excluido com sucesso"));
		montadoras = new GenericDAO<Montadora>(Montadora.class).listarTodos();
	}

	public List<Montadora> listarPorNome(String nomeMontadora) {
		System.out.println("Entrou no metodo listarPorNome: " + nomeMontadora);
		try {
			System.out.println("ENTROU NO TRY");
			montadorasSelecionados = montadoraDAO.buscaMontadoraByNome(nomeMontadora);
		} catch (Exception e) {
			System.out.println("ERROR Exception: " + e);
		}
		System.out.println("Entrou no metodo listarPorNome: " + nomeMontadora + " E " + nomeMontadora);
		for (Montadora m : montadorasSelecionados) {
			System.out.println("Montadora: " + m.getNome());
		}
		return montadorasSelecionados;
	}

	public String limparMontadora() {
		this.montadora = new Montadora();
		return "cadastrarMontadoras.xhtml?faces-redirect=true";
	}
	
	public void detalheMontadora(Montadora montadora){
		this.montadora = montadora;
	}

	public Montadora getMontadora() {
		return montadora;
	}

	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}

	public List<Montadora> getMontadoras() {
		return montadoras;
	}

	public void setMontadoras(List<Montadora> montadoras) {
		this.montadoras = montadoras;
	}

	public List<Montadora> getMontadorasSelecionados() {
		return montadorasSelecionados;
	}

	public void setMontadorasSelecionados(List<Montadora> montadorasSelecionados) {
		this.montadorasSelecionados = montadorasSelecionados;
	}

	public String getMensagemCadastroSucesso() {
		return mensagemCadastroSucesso;
	}

	public void setMensagemCadastroSucesso(String mensagemCadastroSucesso) {
		this.mensagemCadastroSucesso = mensagemCadastroSucesso;
	}

}
