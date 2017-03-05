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

@ManagedBean(name = "Montadora")
@SessionScoped
public class MontadoraController {

	@Autowired
	private List<Montadora> montadorasSelecionados;
	
	private MontadoraDAO montadoraDAO = new MontadoraDAO();

	private Montadora montadora = new Montadora();
	private List<Montadora> montadoras = new ArrayList<Montadora>();

	public MontadoraController() {
		montadoras = new GenericDAO<Montadora>(Montadora.class).listarTodos();
		montadora = new Montadora();
		montadorasSelecionados = new ArrayList<>();
	}

	/* VERIFICAR COMO FAZER PARA LISTA CARREGAR AO INICIAR O SISTEMA */
	/*
	 * @SuppressWarnings("unused")
	 * 
	 * @PostConstruct public void init() { List<Montadora> listaMontadoras = new
	 * ArrayList<Montadora>(); listaMontadoras = new MontadoraDAO().listar(); }
	 */

	public String salvar() {
		new GenericDAO<Montadora>(Montadora.class).salvar(montadora);
		montadora = new Montadora();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Montadora cadastrada com sucesso!"));
		montadoras = new GenericDAO<Montadora>(Montadora.class).listarTodos();
		return "listarMontadoras?faces-redirect=true";
	}

	public String editar(Montadora montadora) {
		this.montadora = montadora;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Montadora editado com sucesso!"));
		return "cadastrarMontadoras.xhtml?faces-redirect=true";
	}

	public void excluir(Montadora montadora) {
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

}
