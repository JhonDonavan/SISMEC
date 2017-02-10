package model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ModeloVeiculo {

	private Integer id;
	private String nome;
	private String sigla;
	private String motor;
	private Integer PotenciaCavalos;
	private Integer numPortas;
	private TipoCombustivel combustivel_1;
	private TipoCombustivel combustivel_2;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public Integer getPotenciaCavalos() {
		return PotenciaCavalos;
	}

	public void setPotenciaCavalos(Integer potenciaCavalos) {
		PotenciaCavalos = potenciaCavalos;
	}

	public Integer getNumPortas() {
		return numPortas;
	}

	public void setNumPortas(Integer numPortas) {
		this.numPortas = numPortas;
	}

	public TipoCombustivel getCombustivel_1() {
		return combustivel_1;
	}

	public void setCombustivel_1(TipoCombustivel combustivel_1) {
		this.combustivel_1 = combustivel_1;
	}

	public TipoCombustivel getCombustivel_2() {
		return combustivel_2;
	}

	public void setCombustivel_2(TipoCombustivel combustivel_2) {
		this.combustivel_2 = combustivel_2;
	}
}
