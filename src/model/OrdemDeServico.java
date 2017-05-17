package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ordemDeServicosMB")
public class OrdemDeServico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "ORDEM_DE_SERVICO_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ORDEM_DE_SERVICO_ID", sequenceName = "SEQ_ORDEM_DE_SERVICO", allocationSize = 1)
	private Integer id;

	@OneToMany(mappedBy = "ordemDeServico", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<ItemServico> itemServico = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "veiculo_id")
	private Veiculo veiculo;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@OneToOne
	private Pagamento pagamento;

	@ManyToOne
	@JoinColumn(name = "gerente_id")
	private Gerente gerente;

	@ManyToOne
	@JoinColumn(name = "atendente_id")
	private Atendente atendente;

	@ManyToOne
	@JoinColumn(name = "mecanico_id")
	private Mecanico mecanico;

	private Date dataInicio;

	private Date dataPrevisto;

	private Date dataConclusao;

	private FormaPagamento formaPagamento;

	private BigDecimal valorTotal = BigDecimal.ZERO;

	public Integer getId() {
		return id;
	}

	public List<ItemServico> getItemServico() {
		return itemServico;
	}

	public void setItemServico(List<ItemServico> itemServico) {
		this.itemServico = itemServico;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public Atendente getAtendente() {
		return atendente;
	}

	public void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataPrevisto() {
		return dataPrevisto;
	}

	public void setDataPrevisto(Date dataPrevisto) {
		this.dataPrevisto = dataPrevisto;
	}

	public Date getDataConclusao() {
		return dataConclusao;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atendente == null) ? 0 : atendente.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dataConclusao == null) ? 0 : dataConclusao.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((dataPrevisto == null) ? 0 : dataPrevisto.hashCode());
		result = prime * result + ((formaPagamento == null) ? 0 : formaPagamento.hashCode());
		result = prime * result + ((gerente == null) ? 0 : gerente.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemServico == null) ? 0 : itemServico.hashCode());
		result = prime * result + ((mecanico == null) ? 0 : mecanico.hashCode());
		result = prime * result + ((pagamento == null) ? 0 : pagamento.hashCode());
		result = prime * result + ((veiculo == null) ? 0 : veiculo.hashCode());
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
		OrdemDeServico other = (OrdemDeServico) obj;
		if (atendente == null) {
			if (other.atendente != null)
				return false;
		} else if (!atendente.equals(other.atendente))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dataConclusao == null) {
			if (other.dataConclusao != null)
				return false;
		} else if (!dataConclusao.equals(other.dataConclusao))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (dataPrevisto == null) {
			if (other.dataPrevisto != null)
				return false;
		} else if (!dataPrevisto.equals(other.dataPrevisto))
			return false;
		if (formaPagamento != other.formaPagamento)
			return false;
		if (gerente == null) {
			if (other.gerente != null)
				return false;
		} else if (!gerente.equals(other.gerente))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemServico == null) {
			if (other.itemServico != null)
				return false;
		} else if (!itemServico.equals(other.itemServico))
			return false;
		if (mecanico == null) {
			if (other.mecanico != null)
				return false;
		} else if (!mecanico.equals(other.mecanico))
			return false;
		if (pagamento == null) {
			if (other.pagamento != null)
				return false;
		} else if (!pagamento.equals(other.pagamento))
			return false;
		if (veiculo == null) {
			if (other.veiculo != null)
				return false;
		} else if (!veiculo.equals(other.veiculo))
			return false;
		return true;
	}

	public void adicionarItemVazio() {
		Servico servico = new Servico();

		ItemServico item = new ItemServico();

		item.setServico(servico);

		item.setOrdemDeServico(this);

		this.getItemServico().add(0, item);
	}

}
