package teste;

import model.Veiculo;
import modelDAO.VeiculoDAO;

public class TesteClass {

	public static void main(String[] args) {
		Veiculo v = new Veiculo();
		VeiculoDAO dao = new VeiculoDAO();
		
		v.setCidade("Duque de Caxias");
		v.setCor("PRETO");
		v.setPlaca("FFF5676");
		v.setUf("RJ");
		
		
		dao.salvar(v);
		System.out.println("veiculo de placa " + v.getPlaca() + " Salvo com sucesso");
		System.out.println("+++++++++++");
		System.out.println("+++++++++++");
		System.out.println("+++++++++++");
		System.out.println("+++++++++++");
		
		try {
			dao.remove(v);
			System.out.println("veiculo de placa " + v.getPlaca() + " excluido com sucesso");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	
	}

}
