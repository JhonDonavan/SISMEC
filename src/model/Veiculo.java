package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "VEICULO_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "VEICULO_ID", sequenceName = "SEQ_VEICULO", allocationSize = 1)
	private Integer Id;

	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="ordem_de_servico_id")
	private OrdemDeServico ordemDeServico;
	
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public OrdemDeServico getOrdemDeServico() {
		return ordemDeServico;
	}

	public void setOrdemDeServico(OrdemDeServico ordemDeServico) {
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
	public String toString() {
		return "Veiculo [Id=" + Id + ", cliente=" + cliente + ", ordemDeServico=" + ordemDeServico + ", modelo="
				+ modelo + ", placa=" + placa + ", uf=" + uf + ", cidade=" + cidade + ", cor=" + cor + "]";
	}
}
