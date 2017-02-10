package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.Veiculo;

@ManagedBean
public class VeiculoController {
	
	private Veiculo veiculo = new Veiculo();
	
	public void salvar(){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veiculo salvo com sucesso!"));
		
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	

}
