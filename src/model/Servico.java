package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Servico implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "SERVICO_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SERVICO_ID", sequenceName = "SEQ_SERVICO", allocationSize = 1)
	private long id;

}
