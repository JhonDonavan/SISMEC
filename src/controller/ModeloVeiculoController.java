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
		return "cadastrarModeloVeiculo?faces-redirect=true";
		
		
	}

	public List<Montadora> listarPorNome(String nomeMontadora){
		System.out.println("Entrou no metodo listarPorNome: " + nomeMontadora);
		montadorasSelecionados = modeloVeiculoDAO.buscaMontadoraByNome(nomeMontadora);
		System.out.println("Entrou no metodo listarPorNome: " + nomeMontadora + " E " + nomeMontadora);
		for(Montadora m : montadorasSelecionados){
			System.out.println("Montadora: " + m.getNome() + " + "  + m.getPais() + " + "  + m.getSite());
		}
		if(montadorasSelecionados.isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Montadora de veiculo nao cadastrado."));
		}
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
