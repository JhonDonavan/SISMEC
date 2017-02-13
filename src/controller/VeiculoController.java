package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Veiculo;
import modelDAO.VeiculoDAO;
@ManagedBean
@SessionScoped
public class VeiculoController {
	
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	private Veiculo veiculo = new Veiculo();
	
	public VeiculoController(){
		 veiculo = new Veiculo();
	}
	
	public void salvar(){
		new VeiculoDAO().salvar(veiculo);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veiculo salvo com sucesso!"));
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	

}
