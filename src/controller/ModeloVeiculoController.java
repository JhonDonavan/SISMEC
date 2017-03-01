package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.ModeloVeiculo;
import modelDAO.ModeloVeiculoDAO;

@ManagedBean(name = "Modelo")
@SessionScoped
public class ModeloVeiculoController {
	private ModeloVeiculo modeloVeiculo = new ModeloVeiculo();
	private List<ModeloVeiculo> modeloVeiculos = new ArrayList<ModeloVeiculo>();
	
	
	public String Salvar(){
		new ModeloVeiculoDAO().salvar(modeloVeiculo);
		return null;
	}
}
