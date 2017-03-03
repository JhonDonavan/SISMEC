package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.ModeloVeiculo;
import model.Montadora;
import modelDAO.GenericDAO;
import modelDAO.ModeloVeiculoDAO;

@ManagedBean(name = "ModeloVeiculo")
@SessionScoped
public class ModeloVeiculoController {
	private ModeloVeiculo modeloVeiculo = new ModeloVeiculo();
	private List<ModeloVeiculo> modeloVeiculos = new ArrayList<ModeloVeiculo>();
	
	public ModeloVeiculoController(){
		modeloVeiculo = new ModeloVeiculo();
		modeloVeiculos = new GenericDAO<ModeloVeiculo>(ModeloVeiculo.class).listarTodos();
	}
	
	
	public List<String> sugerirMontadoras(String consulta){
		System.out.println("Consultando: " + consulta);
		return new ArrayList<>();
	}
	
	public String Salvar(){
		new ModeloVeiculoDAO().salvar(modeloVeiculo);
		new GenericDAO<ModeloVeiculo>(ModeloVeiculo.class).salvar(modeloVeiculo);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modelo de veiculo cadastrado com sucesso!"));
		return "cadastrarModeloVeiculo?faces-redirect=true";
	}
}
