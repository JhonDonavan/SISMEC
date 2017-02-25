package teste;

import model.ModeloVeiculo;
import model.Montadora;
import model.TipoCombustivel;
import model.Veiculo;
import modelDAO.ModeloDAO;
import modelDAO.MontadoraDAO;
import modelDAO.VeiculoDAO;

public class TesteRelacionamentoModeloVeiculo {
	public static void main(String[] args) {
		Veiculo v = new Veiculo();
		VeiculoDAO daoV = new VeiculoDAO();

		ModeloVeiculo mv = new ModeloVeiculo();
		ModeloDAO daoM = new ModeloDAO();
		
		Montadora mon = new Montadora();
		MontadoraDAO daoMON = new MontadoraDAO();
		
		mv.setCombustivel_1(TipoCombustivel.GASOLINA);
		mv.setCombustivel_2(TipoCombustivel.DIESEL);
		mv.setMotor("1.0");
		mv.setNome("FORD KA");
		mv.setNumPortas(4);
		mv.setPotenciaCavalos(90);
		mv.setSigla("KA");
		
		
		v.setPlaca("GHT8875");
		v.setCidade("ESPIRITO SANTO");
		v.setCor("CINZA");
		v.setUf("ES");
		v.setModelo(mv);
		
		daoV.salvar(v);
		
		System.out.println("Veiculo e modelo cadastrado com sucesso");
		

	}
}
