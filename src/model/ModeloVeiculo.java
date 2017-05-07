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
import javax.persistence.Table;

@ManagedBean
@Entity
@Table(name="veiculosModelo")
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PotenciaCavalos == null) ? 0 : PotenciaCavalos.hashCode());
		result = prime * result + ((combustivel_1 == null) ? 0 : combustivel_1.hashCode());
		result = prime * result + ((combustivel_2 == null) ? 0 : combustivel_2.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((montadora == null) ? 0 : montadora.hashCode());
		result = prime * result + ((motor == null) ? 0 : motor.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numPortas == null) ? 0 : numPortas.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
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
		ModeloVeiculo other = (ModeloVeiculo) obj;
		if (PotenciaCavalos == null) {
			if (other.PotenciaCavalos != null)
				return false;
		} else if (!PotenciaCavalos.equals(other.PotenciaCavalos))
			return false;
		if (combustivel_1 != other.combustivel_1)
			return false;
		if (combustivel_2 != other.combustivel_2)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (montadora == null) {
			if (other.montadora != null)
				return false;
		} else if (!montadora.equals(other.montadora))
			return false;
		if (motor == null) {
			if (other.motor != null)
				return false;
		} else if (!motor.equals(other.motor))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numPortas == null) {
			if (other.numPortas != null)
				return false;
		} else if (!numPortas.equals(other.numPortas))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		if (veiculo == null) {
			if (other.veiculo != null)
				return false;
		} else if (!veiculo.equals(other.veiculo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ModeloVeiculo [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", motor=" + motor
				+ ", PotenciaCavalos=" + PotenciaCavalos + ", numPortas=" + numPortas + ", combustivel_1="
				+ combustivel_1 + ", combustivel_2=" + combustivel_2 + ", montadora=" + montadora + ", veiculo="
				+ veiculo + "]";
	}
	
}
