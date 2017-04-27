package model;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
@ManagedBean
@Entity
public class Montadora implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "MONTADORA_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "MONTADORA_ID", sequenceName = "SEQ_MONTADORA", allocationSize = 1)
	private Integer id;
	private String nome;
	private String pais;
	private String site;
	
	
	@OneToMany(mappedBy = "montadora", targetEntity = ModeloVeiculo.class, fetch = FetchType.LAZY)
	private List<ModeloVeiculo> modeloVeiculo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Integer getId() {
		return id;
	}

	public List<ModeloVeiculo> getModeloVeiculo() {
		return modeloVeiculo;
	}

	public void setModeloVeiculo(List<ModeloVeiculo> modeloVeiculo) {
		this.modeloVeiculo = modeloVeiculo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Montadora other = (Montadora) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	

}
