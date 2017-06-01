package filter;

import java.io.Serializable;
import java.util.Date;

import model.StatusOrcamento;

public class OrdemDeServicoFilter implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer numeroDe;
	private Integer numeroAte;
	private Date dataCriacaoDe;
	private Date dataCriacaoAte;
	private String nomeMecanico;
	private String nomeCliente;
	private StatusOrcamento[] statuses;

	public Integer getNumeroDe() {
		return numeroDe;
	}

	public void setNumeroDe(Integer numeroDe) {
		this.numeroDe = numeroDe;
	}

	public Integer getNumeroAte() {
		return numeroAte;
	}

	public void setNumeroAte(Integer numeroAte) {
		this.numeroAte = numeroAte;
	}

	public Date getDataCriacaoDe() {
		return dataCriacaoDe;
	}

	public void setDataCriacaoDe(Date dataCriacaoDe) {
		this.dataCriacaoDe = dataCriacaoDe;
	}

	public Date getDataCriacaoAte() {
		return dataCriacaoAte;
	}

	public void setDataCriacaoAte(Date dataCriacaoAte) {
		this.dataCriacaoAte = dataCriacaoAte;
	}

	public String getNomeMecanico() {
		return nomeMecanico;
	}

	public void setNomeMecanico(String nomeMecanico) {
		this.nomeMecanico = nomeMecanico;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public StatusOrcamento[] getStatuses() {
		return statuses;
	}

	public void setStatuses(StatusOrcamento[] statuses) {
		this.statuses = statuses;
	}

}
