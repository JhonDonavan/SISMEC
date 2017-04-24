package model;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@ManagedBean
@Entity
public class ModeloVeiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "MODELOVEICULO_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "MODELOVEICULO_ID", sequenceName = "SEQ_MODELOVEICULO", allocationSize = 1)
	private Integer id;
	private String nome;
	private String sigla;
	private String motor;
	private Integer PotenciaCavalos;
	private Integer numPortas;
	private TipoCombustivel combustivel_1;
	private TipoCombustivel combustivel_2;
	
	@ManyToOne
	@JoinColumn(name="montadora_id")
	private Montadora montadora;
	
	@OneToMany(mappedBy = "modelo", targetEntity = Veiculo.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Veiculo> veiculo;
	

	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public Integer getPotenciaCavalos() {
		return PotenciaCavalos;
	}

	public void setPotenciaCavalos(Integer potenciaCavalos) {
		PotenciaCavalos = potenciaCavalos;
	}

	public Integer getNumPortas() {
		return numPortas;
	}

	public void setNumPortas(Integer numPortas) {
		this.numPortas = numPortas;
	}

	public TipoCombustivel getCombustivel_1() {
		return combustivel_1;
	}

	public void setCombustivel_1(TipoCombustivel combustivel_1) {
		this.combustivel_1 = combustivel_1;
	}

	public TipoCombustivel getCombustivel_2() {
		return combustivel_2;
	}

	public void setCombustivel_2(TipoCombustivel combustivel_2) {
		this.combustivel_2 = combustivel_2;
	}

	public Montadora getMontadora() {
		return montadora;
	}

	public void setMontadora(Montadora montadora) {
		this.montadora = montadora;
	}

	@Override
	public String toString() {
		return "ModeloVeiculo [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", motor=" + motor
				+ ", PotenciaCavalos=" + PotenciaCavalos + ", numPortas=" + numPortas + ", combustivel_1="
				+ combustivel_1 + ", combustivel_2=" + combustivel_2 + ", montadora=" + montadora + ", veiculo="
				+ veiculo + "]";
	}
	
}
