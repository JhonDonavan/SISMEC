package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Veiculo;
import modelDAO.GenericDAO;

@ManagedBean(name = "Veiculo")
@SessionScoped
public class VeiculoController {

	
	private Veiculo veiculo = new Veiculo();
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	
		
	public VeiculoController() {
		veiculos = new GenericDAO<Veiculo>(Veiculo.class).listarTodos();
		veiculo = new Veiculo();
	}
	
	/*VERIFICAR COMO FAZER PARA LISTA CARREGAR AO INICIAR O SISTEMA*/
	/*@SuppressWarnings("unused")
	@PostConstruct
	public void init(){
		List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
		listaVeiculos = new VeiculoDAO().listar();
	}
*/
	public String salvar() {
		new GenericDAO<Veiculo>(Veiculo.class).salvar(veiculo);
		veiculo = new Veiculo();
		veiculos = new GenericDAO<Veiculo>(Veiculo.class).listarTodos();
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Veiculo salvo com sucesso!"));
		return "listarVeiculos?faces-redirect=true";
	}

	public String editar(Veiculo veiculo) {
		this.veiculo = veiculo;
		return "cadastroVeiculo.xhtml?faces-redirect=true";
	}

	/*METODO ABAIXO � USADO COM EXCLUSAO PELO CONFIRM DALOG // NAO ESTA EM USO NO MOMENTO*/
	public void prepararExclusao(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public void excluir(Veiculo veiculo) {
		new GenericDAO<Veiculo>(Veiculo.class).excluir(veiculo);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Veiculo excluido com sucesso"));
		veiculos = new GenericDAO<Veiculo>(Veiculo.class).listarTodos();
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}
