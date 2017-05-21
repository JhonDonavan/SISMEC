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
	public String toString() {
		return "Servico [id=" + id + ", peca=" + peca + ", ordemDeServico=" + ", nome=" + nome + ", prazo=" + prazo
				+ ", valor=" + valor + "]";
	}
}
