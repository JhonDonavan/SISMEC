package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Fornecedor implements Serializable{
	
	private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "FORNECEDOR_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "FORNECEDOR_ID", sequenceName = "SEQ_FORNECEDOR", allocationSize = 1)
	private Integer id;
	
	@Embedded
	private Endereco endereco;
	
	@OneToMany(mappedBy = "fornecedor", targetEntity = Peca.class, 
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Peca> peca;
	
	private String nome;
	
	private String telfornecedor;
	
	private String email;
	
	private String cnpg;

	public Integer getId() {
		return id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public String getTelfornecedor() {
		return telfornecedor;
	}

	public void setTelfornecedor(String telfornecedor) {
		this.telfornecedor = telfornecedor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpg() {
		return cnpg;
	}

	public void setCnpg(String cnpg) {
		this.cnpg = cnpg;
	}
	
	
}
