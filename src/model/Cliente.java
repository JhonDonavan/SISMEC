package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "CLIENTE_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "CLIENTE_ID", sequenceName = "SEQ_CLIENTE", allocationSize = 1)
	private Integer id;

	@Embedded
	private Endereco endereco;

	@OneToMany(mappedBy = "cliente", targetEntity = Veiculo.class, fetch = FetchType.LAZY)
	private List<Veiculo> veiculo;

	private String nome;

	private String cpf;

	private String telefone;

	private String celular;
	
	private String email;

	public Integer getId() {
		return id;
	}

	public Endereco getEndereco() {
		if (endereco == null)
			endereco = new Endereco();

		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Veiculo> getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
