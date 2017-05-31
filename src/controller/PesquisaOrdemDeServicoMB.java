package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import filter.OrdemDeServicoFilter;
import repository.OrdemDeServico;
import model.StatusOrcamento;

@Named
@ManagedBean(name = "pesquisaOrdemDeServicoMB")
@SessionScoped
public class PesquisaOrdemDeServicoMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	OrdemDeServico os = new OrdemDeServico();
	
	private OrdemDeServicoFilter filtro;
	private List<OrdemDeServico> ordemDeServicosFiltrados;
	
	public PesquisaOrdemDeServicoMB() {
		filtro = new OrdemDeServicoFilter();
		ordemDeServicosFiltrados = new ArrayList<>();
	}

	public void pesquisar() {
		ordemDeServicosFiltrados = os.filtrados(filtro);
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
