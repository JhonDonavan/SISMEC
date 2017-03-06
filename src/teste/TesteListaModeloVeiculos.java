package teste;

import java.util.ArrayList;
import java.util.List;

import model.ModeloVeiculo;
import modelDAO.GenericDAO;

public class TesteListaModeloVeiculos {

	public static void main(String[] args) {

		List<ModeloVeiculo> modeloVeiculos = new ArrayList<ModeloVeiculo>();
		modeloVeiculos = new GenericDAO<ModeloVeiculo>(ModeloVeiculo.class).listarTodos();

		for (ModeloVeiculo valor : modeloVeiculos) {
			System.out.println("Modelo: " + valor.getNome() + " + "  + valor.getMontadora().getNome());

		}

	}
}
