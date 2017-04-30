package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Usuario {
	
	 @Id
     @Column(name="id", nullable=false, unique=true)
     private int id;
	 
     @Column(name="userName", nullable=false, unique=true)
     private String nomeUsuario;
     
     @Column(name="email", nullable=false, unique=true)
     private String email;
     
     @Column(name="password", nullable=false, unique=false)
     private String senha;

     @Column(name="lastAccess", unique=true)
     @Temporal(TemporalType.DATE)
     private Date ultimoAcesso;

	public String getNomeUsuario() {
		return nomeUsuario;
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
}
