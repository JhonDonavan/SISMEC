package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "SERVICO_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SERVICO_ID", sequenceName = "SEQ_SERVICO", allocationSize = 1)
	private long id;

	@OneToMany(mappedBy = "servico", targetEntity = Peca.class, fetch = FetchType.LAZY)
	private List<Peca> peca;
	
	@ManyToOne
	@JoinColumn(name="ordem_de_servico_id")
	private OrdemDeServico ordemDeServico;

	private String nome;

	private Date prazo;

	private double valor;

	public long getId() {
		return id;
	}

	public List<Peca> getPeca() {
		return peca;
	}

	public void setPeca(List<Peca> peca) {
		this.peca = peca;
	}

	public OrdemDeServico getOrdemDeServico() {
		return ordemDeServico;
	}

	public void setOrdemDeServico(OrdemDeServico ordemDeServico) {
		this.ordemDeServico = ordemDeServico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getPrazo() {
		return prazo;
	}

	public void setPrazo(Date prazo) {
		this.prazo = prazo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((ordemDeServico == null) ? 0 : ordemDeServico.hashCode());
		result = prime * result + ((peca == null) ? 0 : peca.hashCode());
		result = prime * result + ((prazo == null) ? 0 : prazo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
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
		Servico other = (Servico) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ordemDeServico == null) {
			if (other.ordemDeServico != null)
				return false;
		} else if (!ordemDeServico.equals(other.ordemDeServico))
			return false;
		if (peca == null) {
			if (other.peca != null)
				return false;
		} else if (!peca.equals(other.peca))
			return false;
		if (prazo == null) {
			if (other.prazo != null)
				return false;
		} else if (!prazo.equals(other.prazo))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Servico [id=" + id + ", peca=" + peca + ", ordemDeServico=" + ordemDeServico + ", nome=" + nome
				+ ", prazo=" + prazo + ", valor=" + valor + "]";
	}
}
