package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Veiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(generator = "CLIENTE_ID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "CLIENTE_ID", sequenceName = "SEQ_CLIENTE", allocationSize = 1)
	private Integer Id;
	
	private String placa;
	
	private String uf;
	
	private String cidade;
	
	private String cor;
	

	public Integer getId() {
		return Id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	

}
