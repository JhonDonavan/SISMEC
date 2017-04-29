package model;

import java.io.Serializable;
import java.util.Date;
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
public class Atendente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "ATENDENTE_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ATENDENTE_ID", sequenceName = "SEQ_ATENDENTE", allocationSize = 1)
	private Integer id;
	
	@OneToMany(mappedBy = "atendente", targetEntity = OrdemDeServico.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrdemDeServico> ordemDeServico;
	
	@OneToMany(mappedBy = "atendente", targetEntity = Orcamento.class, fetch = FetchType.LAZY)
	private List<Orcamento> orcamento;

	@Embedded
	private Endereco endereco;

	private String nome;

	private int matricula;
	
	private String cpf;
	
	private double salario;
	
	private String telefone;

	private String celular;
	
	private String email;
	
	private Date dataNascimento;
	
	
	public Integer getId(){
		return id;
	}

	public List<OrdemDeServico> getOrdemDeServico() {
		return ordemDeServico;
	}

	public void setOrdemDeServico(List<OrdemDeServico> ordemDeServico) {
		this.ordemDeServico = ordemDeServico;
	}

	public List<Orcamento> getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(List<Orcamento> orcamento) {
		this.orcamento = orcamento;
	}

	public Endereco getEndereco() {
		if (endereco == null)
			endereco = new Endereco();
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Atendente other = (Atendente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atendente [id=" + id + ", ordemDeServico=" + ordemDeServico + ", orcamento=" + orcamento + ", endereco="
				+ endereco + ", nome=" + nome + ", matricula=" + matricula + ", cpf=" + cpf + ", salario=" + salario
				+ ", telefone=" + telefone + ", celular=" + celular + ", email=" + email + ", dataNascimento="
				+ dataNascimento + "]";
	}
	
}
