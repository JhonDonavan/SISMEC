package model;

import java.beans.Transient;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "item_servico")
public class ItemServico implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "item_servico_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "item_servico_id", sequenceName = "item_servico_id", allocationSize = 1)
	private long id;
	private Integer quantidade = 1;
	private BigDecimal valorUnitario = BigDecimal.ZERO;
	private Servico servico;
	
	@ManyToOne
	@JoinColumn(name = "ordemDeServico_id", nullable = false)
	private OrdemDeServico ordemDeServico;
	
	public long getId() {
		return id;
	}
	
	@Column(nullable = false, length = 3)
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	@Column(name = "valor_unitario", nullable = false, precision = 10, scale = 2)
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	@ManyToOne
	@JoinColumn(name = "servico_id", nullable = false)
	public Servico getServico() {
		return servico;
	}
	
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	public OrdemDeServico getOrdemDeServico() {
		return ordemDeServico;
	}
	
	public void setOrdemDeServico(OrdemDeServico ordemDeServico) {
		this.ordemDeServico = ordemDeServico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((ordemDeServico == null) ? 0 : ordemDeServico.hashCode());
		result = prime * result + ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((servico == null) ? 0 : servico.hashCode());
		result = prime * result + ((valorUnitario == null) ? 0 : valorUnitario.hashCode());
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
		ItemServico other = (ItemServico) obj;
		if (id != other.id)
			return false;
		if (ordemDeServico == null) {
			if (other.ordemDeServico != null)
				return false;
		} else if (!ordemDeServico.equals(other.ordemDeServico))
			return false;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (servico == null) {
			if (other.servico != null)
				return false;
		} else if (!servico.equals(other.servico))
			return false;
		if (valorUnitario == null) {
			if (other.valorUnitario != null)
				return false;
		} else if (!valorUnitario.equals(other.valorUnitario))
			return false;
		return true;
	}
	
	@javax.persistence.Transient
	public boolean isServicoAssociado(){
		return this.getServico() != null && this.getServico().getId() != null;
	}

	@javax.persistence.Transient
	public BigDecimal getValorTotal() {
		return this.getServico().getValor();
	}
}
