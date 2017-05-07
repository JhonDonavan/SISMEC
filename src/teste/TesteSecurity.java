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
		
		/*auto.setDescricao("ADMINISTRADOR DO SISTEMA");
		auto.setNome("ADMINISTRADORES");
		new GenericDAO<Autorizacao>(Autorizacao.class).salvar(auto);
		
		auto.setDescricao("GERENTE DA OFICINA");
		auto.setNome("GERENTES");
		new GenericDAO<Autorizacao>(Autorizacao.class).salvar(auto);
		
		auto.setDescricao("MECÂNICO DA OFICINA");
		auto.setNome("MECANICOS");
		new GenericDAO<Autorizacao>(Autorizacao.class).salvar(auto);
		
		auto.setDescricao("ATENDENTE DA OFICINA");
		auto.setNome("ATENDENTES");
		new GenericDAO<Autorizacao>(Autorizacao.class).salvar(auto);*/
		
		
		/*CRIA USUARIO ADMINISTRADOR*/
		Autorizacao admin = new Autorizacao();
		admin = new GenericDAO<Autorizacao>(Autorizacao.class).obterPorId(1);
		
		List<Autorizacao> autorizacoesADMIN = new ArrayList<>();
		autorizacoesADMIN.add(admin);
	
		usuario.setEmail("admin@gmail.com");
		usuario.setNomeUsuario("admin");
		usuario.setSenha("123");
		usuario.setAutorizacoes(autorizacoesADMIN);
		new GenericDAO<Usuario>(Usuario.class).salvar(usuario);
		
	/*	CRIA USUARIO GERENTE*/
		Autorizacao GERENTE = new Autorizacao();
		GERENTE = new GenericDAO<Autorizacao>(Autorizacao.class).obterPorId(2);
		
		List<Autorizacao> autorizacoesGerente = new ArrayList<>();
		autorizacoesGerente.add(GERENTE);
	
		usuario.setEmail("gerente@gmail.com");
		usuario.setNomeUsuario("gerente");
		usuario.setSenha("123");
		usuario.setAutorizacoes(autorizacoesGerente);
		new GenericDAO<Usuario>(Usuario.class).salvar(usuario);
		
		/*CRIA USUARIO MECANICO*/
		Autorizacao MECANICO = new Autorizacao();
		MECANICO = new GenericDAO<Autorizacao>(Autorizacao.class).obterPorId(3);
		
		List<Autorizacao> autorizacoesMecanico = new ArrayList<>();
		autorizacoesMecanico.add(MECANICO);
	
		usuario.setEmail("mecanico@gmail.com");
		usuario.setNomeUsuario("mecanico");
		usuario.setSenha("123");
		usuario.setAutorizacoes(autorizacoesMecanico);
		new GenericDAO<Usuario>(Usuario.class).salvar(usuario);
		
		
		/*CRIA USUARIO ATENDENTE*/
		Autorizacao ATENDENTE = new Autorizacao();
		ATENDENTE = new GenericDAO<Autorizacao>(Autorizacao.class).obterPorId(4);
		
		List<Autorizacao> autorizacoesAtendente = new ArrayList<>();
		autorizacoesAtendente.add(ATENDENTE);
	
		usuario.setEmail("atendente@gmail.com");
		usuario.setNomeUsuario("atendente");
		usuario.setSenha("123");
		usuario.setAutorizacoes(autorizacoesAtendente);
		new GenericDAO<Usuario>(Usuario.class).salvar(usuario);
		

	}

}
