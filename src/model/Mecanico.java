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

@Entity
public class Mecanico implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "MECANICO_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "MECANICO_ID", sequenceName = "SEQ_MECANICO", allocationSize = 1)
	private Integer id;
	
	@OneToMany(mappedBy = "mecanico", targetEntity = OrdemDeServico.class, fetch = FetchType.LAZY)
	private List<OrdemDeServico> ordemDeSerivco;
	
	@OneToMany(mappedBy = "mecanico", targetEntity = Orcamento.class, fetch = FetchType.LAZY)
	private List<Orcamento> orcamento;

	@Embedded
	private Endereco endereco;

	private String nome;

	private int matricula;
	
	private String cpf;
	
	private double salario;
	
	private double comissao;
	
	private String telefone;

	private String celular;
	
	private String email;
	
	private String login;
	
	private String senha;
	
	private Date dataNascimento;
	
	public Integer getId(){
		return id;
	}

	public List<OrdemDeServico> getOrdemDeSerivco() {
		return ordemDeSerivco;
	}

	public void setOrdemDeSerivco(List<OrdemDeServico> ordemDeSerivco) {
		this.ordemDeSerivco = ordemDeSerivco;
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

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
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
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		long temp;
		temp = Double.doubleToLongBits(comissao);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + matricula;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((orcamento == null) ? 0 : orcamento.hashCode());
		result = prime * result + ((ordemDeSerivco == null) ? 0 : ordemDeSerivco.hashCode());
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
		Mecanico other = (Mecanico) obj;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (Double.doubleToLongBits(comissao) != Double.doubleToLongBits(other.comissao))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
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
		if (orcamento == null) {
			if (other.orcamento != null)
				return false;
		} else if (!orcamento.equals(other.orcamento))
			return false;
		if (ordemDeSerivco == null) {
			if (other.ordemDeSerivco != null)
				return false;
		} else if (!ordemDeSerivco.equals(other.ordemDeSerivco))
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
		return "Mecanico [id=" + id + ", ordemDeSerivco=" + ordemDeSerivco + ", orcamento=" + orcamento + ", endereco="
				+ endereco + ", nome=" + nome + ", matricula=" + matricula + ", cpf=" + cpf + ", salario=" + salario
				+ ", comissao=" + comissao + ", telefone=" + telefone + ", celular=" + celular + ", email=" + email
				+ ", login=" + login + ", senha=" + senha + ", dataNascimento=" + dataNascimento + "]";
	}
}
