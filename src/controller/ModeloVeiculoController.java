package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import model.ModeloVeiculo;
import model.Montadora;
import modelDAO.GenericDAO;
import modelDAO.ModeloVeiculoDAO;

@ManagedBean(name = "ModeloVeiculoController")
@SessionScoped
public class ModeloVeiculoController {

	
	@Autowired
	private ModeloVeiculoDAO modeloVeiculoDAO;
	@Autowired
	private List<Montadora> montadorasSelecionados;
	
	private ModeloVeiculo modeloVeiculo = new ModeloVeiculo();
	private List<ModeloVeiculo> modeloVeiculos = new ArrayList<ModeloVeiculo>();
	
	

	public ModeloVeiculoController() {
		modeloVeiculo = new ModeloVeiculo();
		modeloVeiculos = new GenericDAO<ModeloVeiculo>(ModeloVeiculo.class).listarTodos();
	}

	public String salvar() {
		new GenericDAO<ModeloVeiculo>(ModeloVeiculo.class).salvar(modeloVeiculo);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Modelo de veiculo cadastrado com sucesso!"));
		System.out.println("Objeto " + modeloVeiculo.getNome() + " salvo com sucesso!");
		modeloVeiculos = new GenericDAO<ModeloVeiculo>(ModeloVeiculo.class).listarTodos();
		return "listarModeloVeiculos?faces-redirect=true";
	}
	
	public String editar(ModeloVeiculo modelo){
		this.modeloVeiculo = modelo;
		return "cadastrarModeloVeiculo.xhtml?faces-redirect=true";
	}
	
	public void excluir(ModeloVeiculo modelo){
		System.out.println("1");
		new GenericDAO<ModeloVeiculo>(ModeloVeiculo.class).excluir(modelo);
		System.out.println("2");
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Modelo de Veiculo excluido com sucesso"));
		System.out.println("3");
		modeloVeiculos = new GenericDAO<ModeloVeiculo>(ModeloVeiculo.class).listarTodos();
		System.out.println("4");
	}

	public List<Montadora> listarPorNome(String nomeMontadora){
		montadorasSelecionados = modeloVeiculoDAO.buscaMontadoraByNome(nomeMontadora);
		return montadorasSelecionados;
	}

	public ModeloVeiculo getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(ModeloVeiculo modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	public List<ModeloVeiculo> getModeloVeiculos() {
		return modeloVeiculos;
	}

	public void setModeloVeiculos(List<ModeloVeiculo> modeloVeiculos) {
		this.modeloVeiculos = modeloVeiculos;
	}

}
