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
	public String toString() {
		return "Mecanico [id=" + id + ", ordemDeSerivco=" + ordemDeSerivco + ", orcamento=" + orcamento + ", endereco="
				+ endereco + ", nome=" + nome + ", matricula=" + matricula + ", cpf=" + cpf + ", salario=" + salario
				+ ", comissao=" + comissao + ", telefone=" + telefone + ", celular=" + celular + ", email=" + email
				+ ", login=" + login + ", senha=" + senha + ", dataNascimento=" + dataNascimento + "]";
	}
}
