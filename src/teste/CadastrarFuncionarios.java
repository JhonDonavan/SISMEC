package teste;

import java.util.ArrayList;
import java.util.List;

import model.Autorizacao;
import model.Funcionario;
import model.Usuario;
import modelDAO.GenericDAO;

public class CadastrarFuncionarios {

	public static void main(String[] args) {
		
		
		Autorizacao autorizacao = new Autorizacao();
		
		/*CRIAR AUTORIZAÇÕES*/
		autorizacao.setDescricao("ADMINISTRADOR DO SISTEMA");
		autorizacao.setNome("ADMINISTRADORES");
		new GenericDAO<Autorizacao>(Autorizacao.class).salvar(autorizacao);
		
		autorizacao.setDescricao("GERENTE DA OFICINA");
		autorizacao.setNome("GERENTES");
		new GenericDAO<Autorizacao>(Autorizacao.class).salvar(autorizacao);
		
		autorizacao.setDescricao("MECÂNICO DA OFICINA");
		autorizacao.setNome("MECANICOS");
		new GenericDAO<Autorizacao>(Autorizacao.class).salvar(autorizacao);
		
		autorizacao.setDescricao("ATENDENTE DA OFICINA");
		autorizacao.setNome("ATENDENTES");
		new GenericDAO<Autorizacao>(Autorizacao.class).salvar(autorizacao);
		
		
		
		/*CRIAR FUNCIONARIO*/
		Funcionario f = new Funcionario();
		
		f.setNome("JHON OLIVEIRA");
		f.setCelular("21121221");
		f.setCargo("GERENTE");
		f.setCpf("65656565");
		f.setEmail("TESTE@TESTE");
		f.setMatricula(6565);
		f.setSalario(200);
		f.setTelefone("98988998");
		
		
		
		/*CRIAR USUÁRIO*/
		
		Autorizacao admin = new Autorizacao();
		admin = new GenericDAO<Autorizacao>(Autorizacao.class).obterPorId(1);
		List<Autorizacao> autorizacoes = new ArrayList<>();
		autorizacoes.add(admin);
		Usuario usuario = new Usuario();
		
		
		usuario.setFuncionario(f);
		usuario.setEmail("admin@gmail.com");
		usuario.setNomeUsuario("admin");
		usuario.setSenha("123");
		usuario.setAutorizacoes(autorizacoes);
		new GenericDAO<Usuario>(Usuario.class).salvar(usuario);
		
		
	}

}
