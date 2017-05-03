package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario implements Serializable{
	
	 @Id
     @Column(name="id", nullable=false, unique=true)
     private int id;
	 
     @Column(name="userName", nullable=false, unique=true)
     private String nomeUsuario;
     
     @Column(name="email", nullable=false, unique=true)
     private String email;
     
     @Column(name="password", nullable=false, unique=false)
     private String senha;
     
     @Column(name = "enable", columnDefinition = "BOOLEAN")
     private boolean enable;
     
     @OneToMany(mappedBy = "usuario", targetEntity = Autorizacao.class, fetch = FetchType.LAZY)
     private List<Autorizacao> autorizacoes;
     
     @Column(name="lastAccess", unique=true)
     @Temporal(TemporalType.DATE)
     private Date ultimoAcesso;
     
     public Usuario(){
    	 
     }

	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public boolean isEnable() {
		return enable;
	}



	public void setEnable(boolean enable) {
		this.enable = enable;
	}



	public List<Autorizacao> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(List<Autorizacao> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}



	public int getId() {
		return id;
	}



	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public static void TESTE() {
		System.out.println("TESTE");
		
	}
}
