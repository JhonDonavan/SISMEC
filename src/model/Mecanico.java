package model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Mecanico implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "MECANICO_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "MECANICO_ID", sequenceName = "SEQ_MECANICO", allocationSize = 1)
	private Integer id;

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

}
