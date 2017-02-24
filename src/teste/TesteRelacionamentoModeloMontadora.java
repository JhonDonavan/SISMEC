package teste;

import model.ModeloVeiculo;
import model.Montadora;
import model.TipoCombustivel;
import modelDAO.ModeloDAO;
import modelDAO.MontadoraDAO;

public class TesteRelacionamentoModeloMontadora {
	public static void main(String[] args) {
		
		Montadora montadora = new Montadora();
		ModeloVeiculo mv = new ModeloVeiculo();
		MontadoraDAO montadoraDAO = new MontadoraDAO();
		ModeloDAO modeloDAO = new ModeloDAO();
		
		montadora.setNome("FORD");
		montadora.setPais("EUA");
		montadora.setSite("www.ford.com.br");
		
		
	
		
		mv.setCombustivel_1(TipoCombustivel.DIESEL);
		mv.setCombustivel_2(TipoCombustivel.GASOLINA);
		mv.setMontadora(montadora);
		mv.setMotor("5.0");
		mv.setNome("MUSTANG");
		mv.setNumPortas(2);
		mv.setPotenciaCavalos(450);
		mv.setSigla("SHELB");
		
		
		
		modeloDAO.salvar(mv);
		
		
		System.out.println("Montadorta " + montadora.getNome() + " Cadastrado!");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		System.out.println("Modelo " + mv.getNome() + "cadastrodo com sucesso");
		
		
		
	}
}
