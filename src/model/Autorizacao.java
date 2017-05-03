package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Autorizacao implements Serializable{

	@Id
    private String nome;
	
	@ManyToOne
	@JoinColumn(name="Usuario_id")
	private Usuario usuario;
 
    public Autorizacao() {
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
 
   
 	
}
