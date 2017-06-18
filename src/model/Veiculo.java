package model;

import java.io.Serializable;
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
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="veiculos")
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "VEICULO_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "VEICULO_ID", sequenceName = "SEQ_VEICULO", allocationSize = 1)
	private Integer Id;

	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "veiculo", targetEntity = OrdemDeServico.class, fetch = FetchType.LAZY)
	private List<OrdemDeServico> ordemDeServico;
	
	@ManyToOne
	@JoinColumn(name="modelo_id")
	private ModeloVeiculo modelo;
	
	private String placa;

	private String uf;

	private String cidade;

	private String cor;
	
	public ModeloVeiculo getModelo() {
		return modelo;
	}

	public void setModelo(ModeloVeiculo modelo) {
		this.modelo = modelo;
	}

	public Integer getId() {
		return Id;
	}
	
	

	public void setId(Integer id) {
		Id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<OrdemDeServico> getOrdemDeServico() {
		return ordemDeServico;
	}

	public void setOrdemDeServico(List<OrdemDeServico> ordemDeServico) {
		this.ordemDeServico = ordemDeServico;
	}

	@NotEmpty(message="O campo 'PLACA' deve ser informado")
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@NotEmpty(message="O campo 'UF' deve ser informado")
	@Length(min=2, max=2, message="O campo 'UF' deve conter 2 caracteres. PELO BANCO")
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@NotEmpty(message="O campo 'CIDADE' deve ser informado")
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@NotEmpty(message="O campo 'COR' deve ser informado")
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((ordemDeServico == null) ? 0 : ordemDeServico.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (ordemDeServico == null) {
			if (other.ordemDeServico != null)
				return false;
		} else if (!ordemDeServico.equals(other.ordemDeServico))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Veiculo [Id=" + Id + ", cliente=" + cliente + ", ordemDeServico=" + ordemDeServico + ", modelo="
				+ modelo + ", placa=" + placa + ", uf=" + uf + ", cidade=" + cidade + ", cor=" + cor + "]";
	}
}
