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
import javax.persistence.Table;

@Entity
@Table(name="orcamentos")
public class Orcamento implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atendente == null) ? 0 : atendente.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mecanico == null) ? 0 : mecanico.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorOrcado);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orcamento other = (Orcamento) obj;
		if (atendente == null) {
			if (other.atendente != null)
				return false;
		} else if (!atendente.equals(other.atendente))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mecanico == null) {
			if (other.mecanico != null)
				return false;
		} else if (!mecanico.equals(other.mecanico))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (Double.doubleToLongBits(valorOrcado) != Double.doubleToLongBits(other.valorOrcado))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orcamento [id=" + id + ", observacao=" + observacao + ", data=" + data + ", valorOrcado=" + valorOrcado
				+ ", mecanico=" + mecanico + ", atendente=" + atendente + "]";
	}
}
