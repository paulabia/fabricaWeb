package br.com.fabricadeprogramador.fabricaWeb;

import java.util.List;

import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.UsuarioDao;

public class TestUsuarioDao {
	
	public static void main(String[] args) {
		testCadastrarUsuario();
		//testAlterarUsuario();
		//testExcluiUsuario();
		//testSalvarUsuario();
		//testBuscaPorId();
		//testBuscaTodos();
		//testAutenticarUsuario();
	}

	public static void testCadastrarUsuario(){
		// criando usuario
		Usuario usu = new Usuario();
		usu.setLogin("mateus.sousa");
		usu.setSenha("0323");
		usu.setNome("Mateus");
		
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.cadastrar(usu);
		System.out.println("Cadastrado com sucesso!!!");
	}
	
	public static void testAlterarUsuario(){
		// criando usuario
				Usuario usu = new Usuario();
				usu.setId(5);
				usu.setLogin("ana.siqueira");
				usu.setSenha("12358");
				usu.setNome("Ana Siqueira");
				
				UsuarioDao usuarioDao = new UsuarioDao();
				usuarioDao.alterar(usu);
				System.out.println("Alterado com sucesso!!!");
	}
	
	public static void testExcluiUsuario(){
		Usuario usu = new Usuario();
		usu.setId(3);
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.exclui(usu);
		System.out.println("Excluído com sucesso!!!");
	}
	
	public static void testSalvarUsuario(){
		Usuario usu = new Usuario();
		usu.setLogin("jao.silva");
		usu.setSenha("1111");
		usu.setNome("João");
		
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.cadastrar(usu);
		System.out.println("Cadastrado com sucesso!!!");
	}
	
	public static void testBuscaPorId(){
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usu = usuarioDao.buscaPorId(5);
		
		System.out.println(usu);
	
	}
	
	public static void testBuscaTodos(){
		UsuarioDao usuarioDao = new UsuarioDao();
		List<Usuario> usuarios = usuarioDao.buscaTodos();
		
		for(Usuario usu : usuarios){
			System.out.println(usu);
		}
	}
	
	public static void testAutenticarUsuario(){
		String login = "bia.siqueira";
		String senha = "12358";
		
		UsuarioDao usuarioDao = new UsuarioDao();
		
		Usuario usuario = usuarioDao.autenticar(login, senha);
		if(usuario != null ){
			System.out.println("Usuario "+ usuario+"Autenticado com sucesso!" );
		}else{
			System.out.println("Usuario não encontrado!");
		}
	}

}
