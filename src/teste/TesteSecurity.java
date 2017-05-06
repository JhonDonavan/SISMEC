package teste;

import java.util.ArrayList;
import java.util.List;

import model.Autorizacao;
import model.Usuario;
import modelDAO.GenericDAO;

public class TesteSecurity {

	public static void main(String[] args) {

		Usuario usuario = new Usuario();
		Autorizacao auto = new Autorizacao();
		
	/*	auto.setDescricao("ADMINISTRADOR DO SISTEMA");
		auto.setNome("ADMINSTRADOR");
		new GenericDAO<Autorizacao>(Autorizacao.class).salvar(auto);
		
		auto.setDescricao("GERENTE DA OFICINA");
		auto.setNome("GERENTE");
		new GenericDAO<Autorizacao>(Autorizacao.class).salvar(auto);*/
		
		/*Autorizacao a1 = new Autorizacao();
		a1 = new GenericDAO<Autorizacao>(Autorizacao.class).obterPorId(7);
		
		Autorizacao a2 = new Autorizacao();
		a2 = new GenericDAO<Autorizacao>(Autorizacao.class).obterPorId(8);
		
		List<Autorizacao> autorizacoes = new ArrayList<>();
		autorizacoes.add(a1);
		autorizacoes.add(a2);
		
		
		usuario.setEmail("jhondonavan@gmail.com");
		usuario.setNomeUsuario("jhon");
		usuario.setSenha("123");
		usuario.setAutorizacoes(autorizacoes);
		new GenericDAO<Usuario>(Usuario.class).salvar(usuario);*/
		
		
		
		Usuario teste = new Usuario();
		teste = new GenericDAO<>(Usuario.class).opterPorUserName("jhon");
		
		
		
		
		System.out.println("Email: "  + teste.getEmail());
		System.out.println("USER NAME: "  + teste.getNomeUsuario());
		System.out.println("SENHA: "  + teste.getSenha());
		
		
		for(Autorizacao grupos : teste.getAutorizacoes()){
			System.out.println(grupos.getNome());
		}

	}

}
