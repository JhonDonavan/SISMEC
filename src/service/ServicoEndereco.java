package service;

import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Endereco;

public class ServicoEndereco implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 171188508122915069L;
	
	public Endereco buscarEnderecoPor(String urlJson) {
		System.out.println("CHAMOU O SERVIÇO....");
		
		final GsonBuilder gsonBuilder = new GsonBuilder();
		final Gson gson = gsonBuilder.create();
		Gson g = new Gson();		
		Endereco retornoEndereco = gson.fromJson(urlJson, Endereco.class);		
		return retornoEndereco;
	}

}
