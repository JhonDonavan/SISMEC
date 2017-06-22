package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import model.ModeloVeiculo;
import model.Veiculo;
import modelDAO.GenericDAO;
import modelDAO.ModeloVeiculoDAO;
import modelDAO.VeiculoDAO;

@ManagedBean(name = "Veiculo")
@SessionScoped
public class VeiculoController {

	@Autowired
	private List<ModeloVeiculo> modelosSelecionados;

	private List<Veiculo> placas;
	private Veiculo veiculo = new Veiculo();
	private List<Veiculo> veiculos = new ArrayList<Veiculo>();
	private ModeloVeiculoDAO modeloVeiculoDAO = new ModeloVeiculoDAO();

	public VeiculoController() {
		veiculos = new GenericDAO<Veiculo>(Veiculo.class).listarTodos();
		veiculo = new Veiculo();
		modelosSelecionados = new ArrayList<>();
	}

	public String salvar() {
		new GenericDAO<Veiculo>(Veiculo.class).salvar(veiculo);
		veiculo = new Veiculo();
		veiculos = new GenericDAO<Veiculo>(Veiculo.class).listarTodos();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veiculo salvo com sucesso!"));
		return "listarVeiculos?faces-redirect=true";
	}

	public String editar(Veiculo veiculo) {
		this.veiculo = veiculo;
		return "cadastroVeiculo.xhtml?faces-redirect=true";
	}

	public void prepararExclusao(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public void excluir() {
		try {
			new GenericDAO<Veiculo>(Veiculo.class).excluir(veiculo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veiculo excluido com sucesso"));
			veiculos = new GenericDAO<Veiculo>(Veiculo.class).listarTodos();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"A exclusão deste registro pode ocasionar em perdas ou danos nos registros do sistema, favor consultar o administrador do sistema",
							"A exclusão deste registro pode ocasionar em perdas ou danos nos registros do sistema, favor consultar o administrador do sistema"));
			e.printStackTrace();
		}
	}

	public List<Veiculo> listarPorPlaca(String placa) {
		System.out.println("Entrou no metodo listarPorPlaca: " + placa);
		try {
			System.out.println("ENTROU NO TRY");
			placas = VeiculoDAO.buscaVeiculoByPlaca(placa);
		} catch (Exception e) {
			System.out.println("ERROR Exception: " + e);
		}
		System.out.println("Entrou no metodo listarPorNome: " + placa + " E " + placa);
		for (Veiculo v : placas) {
			System.out.println("Montadora: " + v.getPlaca());
		}
		return placas;
	}

	public String limparVeiculo() {
		this.veiculo = new Veiculo();
		return "cadastroVeiculo.xhtml?faces-redirect=true";
	}

	public void detalhesVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public List<ModeloVeiculo> getModelosSelecionados() {
		return modelosSelecionados;
	}

	public void setModelosSelecionados(List<ModeloVeiculo> modelosSelecionados) {
		this.modelosSelecionados = modelosSelecionados;
	}
}
