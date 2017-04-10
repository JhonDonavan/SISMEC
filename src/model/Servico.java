package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	public String toString() {
		return "Servico [id=" + id + ", peca=" + peca + ", nome=" + nome + ", prazo=" + prazo
				+ ", valor=" + valor + "]";
	}

}
