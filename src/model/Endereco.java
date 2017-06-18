package model;

import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Embeddable
public class Endereco
{
	@SerializedName("cep")
	@Expose
	private String cep;
	
	@SerializedName("logradouro")
	@Expose
	private String logradouro;
	
	@SerializedName("complemento")
	@Expose
	private String complemento;
	
	@SerializedName("bairro")
	@Expose
	private String bairro;
	
	@SerializedName("localidade")
	@Expose
	private String localidade;
	
	@SerializedName("uf")
	@Expose
	private String uf;
	
	@SerializedName("unidade")
	@Expose
	private String unidade;
	
	@SerializedName("ibge")
	@Expose
	private String ibge;
	
	@SerializedName("gia")
	@Expose
	private String gia;
	
	private String numero;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(cep).append(logradouro).append(complemento).append(bairro)
				.append(localidade).append(uf).append(unidade).append(ibge).append(gia).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Endereco) == false) {
			return false;
		}
		Endereco rhs = ((Endereco) other);
		return new EqualsBuilder().append(cep, rhs.cep).append(logradouro, rhs.logradouro)
				.append(complemento, rhs.complemento).append(bairro, rhs.bairro).append(localidade, rhs.localidade)
				.append(uf, rhs.uf).append(unidade, rhs.unidade).append(ibge, rhs.ibge).append(gia, rhs.gia).isEquals();
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}