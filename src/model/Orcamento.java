package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Orcamento implements Serializable{
	
private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "ORCAMENTO_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ORCAMENTO_ID", sequenceName = "SEQ_ORCAMENTO", allocationSize = 1)
	private Integer id;
	
	private String observacao;
	
	private Date data;
	
	private  double valorOrcado;

	@ManyToOne
	@JoinColumn(name="mecanico_id")
	private Mecanico mecanico;
	
	@ManyToOne
	@JoinColumn(name="atendente_id")
	private Mecanico atendente;

	public Integer getId() {
		return id;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValorOrcado() {
		return valorOrcado;
	}

	public void setValorOrcado(double valorOrcado) {
		this.valorOrcado = valorOrcado;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	public Mecanico getAtendente() {
		return atendente;
	}

	public void setAtendente(Mecanico atendente) {
		this.atendente = atendente;
	}
	
}
