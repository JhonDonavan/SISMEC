package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import filter.OrdemDeServicoFilter;
import model.OrdemDeServico;
import model.StatusOrcamento;
import repository.OrdemDeServicos;

@ManagedBean(name = "pesquisaMB")
@SessionScoped
public class PesquisaOrdemDeServicoMB implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	
	OrdemDeServicos ordemDeServicos = new OrdemDeServicos();
	
	private OrdemDeServicoFilter filtro;
	private List<OrdemDeServico> ordemDeServicosFiltrados;
	
	public PesquisaOrdemDeServicoMB() {
		filtro = new OrdemDeServicoFilter();
		ordemDeServicosFiltrados = new ArrayList<>();
	}

	public void pesquisar() {
		ordemDeServicosFiltrados = ordemDeServicos.filtrados(filtro);
	}
	
	public StatusOrcamento[] getStatuses() {
		return StatusOrcamento.values();
	}
	
	public List<OrdemDeServico> getOrdemDeServicosFiltrados() {
		return ordemDeServicosFiltrados;
	}

	public OrdemDeServicoFilter getFiltro() {
		return filtro;
	}

}
