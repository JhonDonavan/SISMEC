package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Montadora;
import model.Veiculo;
import modelDAO.MontadoraDAO;
import modelDAO.VeiculoDAO;

@ManagedBean(name = "Montadora")
@SessionScoped
public class MontadoraController {

	private Montadora montadora = new Montadora();
	private List<Montadora> montadoras = new ArrayList<Montadora>();

	public MontadoraController() {
		montadoras = new MontadoraDAO().listar();
		montadora = new Montadora();
	}

	/* VERIFICAR COMO FAZER PARA LISTA CARREGAR AO INICIAR O SISTEMA */
	/*
	 * @SuppressWarnings("unused")
	 * 
	 * @PostConstruct public void init() { List<Montadora> listaMontadoras = new
	 * ArrayList<Montadora>(); listaMontadoras = new MontadoraDAO().listar(); }
	 */

	public String salvar() {
		new MontadoraDAO().salvar(montadora);
		montadora = new Montadora();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Montadora cadastrada com sucesso!"));
		montadoras = new MontadoraDAO().listar();

		return "listarMontadoras?faces-redirect=true";
	}

	public String editar(Montadora montadora) {
		this.montadora = montadora;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Montadora editado com sucesso!"));
		return "cadastrarMontadoras.xhtml?faces-redirect=true";
	}

	public void excluir(Montadora montadora) {
		new MontadoraDAO().remove(montadora);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Montadora excluido com sucesso"));
		montadoras = new MontadoraDAO().listar();
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

}
