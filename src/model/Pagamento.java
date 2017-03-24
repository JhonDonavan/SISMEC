package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Pagamento {
	
	private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "PAGAMENTO_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "PAGAMENTO_ID", sequenceName = "SEQ_PAGAMENTO", allocationSize = 1)
	private Integer id;
	
	private String formaPagamento;
	
	private Date dataPagamento;
	
	private  double valorTotal;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;

	public Integer getId() {
		return id;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", formaPagamento=" + formaPagamento + ", dataPagamento=" + dataPagamento
				+ ", valorTotal=" + valorTotal + ", cliente=" + cliente + "]";
	}
	
	

	
	

}
