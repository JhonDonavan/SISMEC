package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import model.ModeloVeiculo;
import model.TipoCombustivel;
import modelDAO.GenericDAO;
import modelDAO.ModeloVeiculoDAO;

@ManagedBean(name = "ModeloVeiculoController")
@SessionScoped
public class ModeloVeiculoController {

	
	@Autowired
	private List<ModeloVeiculo> modelosSelecionados;
	
	private ModeloVeiculo modeloVeiculo = new ModeloVeiculo();
	private List<ModeloVeiculo> modeloVeiculos = new ArrayList<ModeloVeiculo>();
	private ModeloVeiculoDAO modeloVeiculoDAO = new ModeloVeiculoDAO();
	private List<TipoCombustivel> combustivel;
	
	@PostConstruct
	public void init(){
		combustivel = Arrays.asList(TipoCombustivel.values());
	}
	

	public ModeloVeiculoController() {
		modeloVeiculo = new ModeloVeiculo();
		modeloVeiculos = new GenericDAO<ModeloVeiculo>(ModeloVeiculo.class).listarTodos();
		modelosSelecionados = new ArrayList<>();
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
	
	public void prepararExclusao(ModeloVeiculo modeloVeiculo){
		this.modeloVeiculo = modeloVeiculo;
		System.out.println(" preparar para excluir modelo veiculo: " + modeloVeiculo.getNome());
	}
	
	public void excluir(){
		new GenericDAO<ModeloVeiculo>(ModeloVeiculo.class).excluir(modeloVeiculo);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Modelo de Veiculo excluido com sucesso"));
		modeloVeiculos = new GenericDAO<ModeloVeiculo>(ModeloVeiculo.class).listarTodos();
	}

	public List<ModeloVeiculo> listarPorNome(String nomeModelo) {
		try {
			modelosSelecionados = modeloVeiculoDAO.buscaModeloByNome(nomeModelo);
		} catch (Exception e) {
			System.out.println("ERROR Exception: " + e);
		}
		for (ModeloVeiculo m : modelosSelecionados) {
			System.out.println("Montadora: " + m.getNome());
		}
		return modelosSelecionados;
	}
	
	public String limparModeloVeiculo(){
		this.modeloVeiculo = new ModeloVeiculo();
		return "cadastrarModeloVeiculo.xhtml?faces-redirect=true";
	}
	
	public void detalheModeloVeiculo(ModeloVeiculo modeloVeiculo){
		this.modeloVeiculo = modeloVeiculo;
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

	public List<TipoCombustivel> getCombustivel() {
		return combustivel;
	}
	
}
