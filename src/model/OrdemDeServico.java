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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class OrdemDeServico implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "ORDEM_DE_SERVICO_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ORDEM_DE_SERVICO_ID", sequenceName = "SEQ_ORDEM_DE_SERVICO", allocationSize = 1)
	private Integer id;
	
	@OneToMany(mappedBy = "ordemDeServico", targetEntity = Veiculo.class, fetch = FetchType.LAZY)
	private List<Veiculo> veiculo;
	
	@OneToMany(mappedBy = "ordemDeServico", targetEntity = Servico.class, fetch = FetchType.LAZY)
	private List<Servico> servico;
	
	@OneToOne
	private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name="gerente_id")
	private Gerente gerente;
	
	@ManyToOne
	@JoinColumn(name="atendente_id")
	private Atendente atendente;
	
	@ManyToOne
	@JoinColumn(name="mecanico_id")
	private Mecanico mecanico;
	
	private Date dataInicio;
	
	private Date dataPrevisto;
	
	private Date dataConclusao;

	public Integer getId() {
		return id;
	}

	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}

	public List<Servico> getServico() {
		return servico;
	}

	public void setServico(List<Servico> servico) {
		this.servico = servico;
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

	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	@Override
	public String toString() {
		return "OrdemDeServico [id=" + id + ", veiculo=" + veiculo + ", servico=" + servico + ", pagamento=" + pagamento
				+ ", gerente=" + gerente + ", atendente=" + atendente + ", mecanico=" + mecanico + ", dataInicio="
				+ dataInicio + ", dataPrevisto=" + dataPrevisto + ", dataConclusao=" + dataConclusao + "]";
	}
}
