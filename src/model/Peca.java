package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Peca implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "PECA_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "PECA_ID", sequenceName = "SEQ_PECA", allocationSize = 1)
	private long id;
	
	private String nome;
	
	private String num;
	
	private int qtd;
	

}
