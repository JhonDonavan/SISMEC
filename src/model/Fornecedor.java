package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

public class Fornecedor implements Serializable{
	
	private static final long SerialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "FORNECEDOR_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "FORNECEDOR_ID", sequenceName = "SEQ_FORNECEDOR", allocationSize = 1)
	private Integer id;
	
	@Embedded
	private Endereco endereco;
	
	@OneToMany(mappedBy = "FORNECEDOR", targetEntity = Peca.class, 
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Peca> peca;
	
	private String nome;
	
	private String telfornecedor;
	
	private String email;
	
	private String cnpg;

}
