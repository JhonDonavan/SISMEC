package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Veiculo;
import modelDAO.VeiculoDAO;

@ManagedBean(name = "Veiculo")
@SessionScoped
public class VeiculoController {

	private Veiculo veiculo = new Veiculo();
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	
	

	public VeiculoController() {
		veiculos = new VeiculoDAO().listar();
		veiculo = new Veiculo();
	}

	public String salvar() {
		new VeiculoDAO().salvar(veiculo);
		veiculo = new Veiculo();
		veiculos = new VeiculoDAO().listar();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veiculo salvo com sucesso!"));
		return "listarVeiculos?faces-redirect=true";
	}
	
	public String editar(Veiculo veiculo){
		this.veiculo = veiculo;
		return "cadastroVeiculo.xhtml?faces-redirect=true";
	}
	
	public void prepararExclusao(Veiculo veiculo){
		this.veiculo = veiculo;
		System.out.println("Fim do metodo prepararExclusao");
	}
	
	public void excluir(){
		new VeiculoDAO().remove(veiculo);
		veiculos = new VeiculoDAO().listar();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veiculo excluido com sucesso!"));
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
