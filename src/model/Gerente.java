package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="gerentes")
public class Gerente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "GERENTE_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GERENTE_ID", sequenceName = "SEQ_GERENTE", allocationSize = 1)
	private Integer id;
	
	@OneToMany(mappedBy = "gerente", targetEntity = OrdemDeServico.class, fetch = FetchType.LAZY)
	private List<OrdemDeServico> ordemDeServico;

	@Embedded
	private Endereco endereco;

	private String nome;

	private int matricula;
	
	private String cpf;
	
	private double salario;
	
	private double bonusSalario;

	private String telefone;

	private String celular;
	
	private String email;
	
	private String login;
	
	private String senha;

	public Integer getId() {
		return id;
	}

	public List<OrdemDeServico> getOrdemDeServico() {
		return ordemDeServico;
	}

	public void setOrdemDeServico(List<OrdemDeServico> ordemDeServico) {
		this.ordemDeServico = ordemDeServico;
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

	public double getBonusSalario() {
		return bonusSalario;
	}

	public void setBonusSalario(double bonusSalario) {
		this.bonusSalario = bonusSalario;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(bonusSalario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + matricula;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((ordemDeServico == null) ? 0 : ordemDeServico.hashCode());
		temp = Double.doubleToLongBits(salario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Gerente other = (Gerente) obj;
		if (Double.doubleToLongBits(bonusSalario) != Double.doubleToLongBits(other.bonusSalario))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (matricula != other.matricula)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (ordemDeServico == null) {
			if (other.ordemDeServico != null)
				return false;
		} else if (!ordemDeServico.equals(other.ordemDeServico))
			return false;
		if (Double.doubleToLongBits(salario) != Double.doubleToLongBits(other.salario))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gerente [id=" + id + ", ordemDeServico=" + ordemDeServico + ", endereco=" + endereco + ", nome=" + nome
				+ ", matricula=" + matricula + ", cpf=" + cpf + ", salario=" + salario + ", bonusSalario="
				+ bonusSalario + ", telefone=" + telefone + ", celular=" + celular + ", email=" + email + ", login="
				+ login + ", senha=" + senha + "]";
	}
}
