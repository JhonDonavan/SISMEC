package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "servicos")
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "SERVICO_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SERVICO_ID", sequenceName = "SEQ_SERVICO", allocationSize = 1)
	private Long id;

	@OneToMany(mappedBy = "servico", targetEntity = Peca.class, fetch = FetchType.LAZY)
	private List<Peca> peca;

	private String nome;

	private Date prazo;

	private BigDecimal valor;

	private Integer quantidadeEstoque = 10;

	public Long getId() {
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

	public BigDecimal getValor() {
		return valor;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((peca == null) ? 0 : peca.hashCode());
		result = prime * result + ((prazo == null) ? 0 : prazo.hashCode());
		result = prime * result + ((quantidadeEstoque == null) ? 0 : quantidadeEstoque.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
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
		if (quantidadeEstoque == null) {
			if (other.quantidadeEstoque != null)
				return false;
		} else if (!quantidadeEstoque.equals(other.quantidadeEstoque))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Servico [id=" + id + ", peca=" + peca + ", ordemDeServico=" + ", nome=" + nome + ", prazo=" + prazo
				+ ", valor=" + valor + "]";
	}
}
