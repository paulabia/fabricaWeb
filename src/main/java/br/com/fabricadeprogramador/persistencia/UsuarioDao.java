package br.com.fabricadeprogramador.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.ConexaoFactory;

public class UsuarioDao {
	private Connection con = ConexaoFactory.getConnection(); 
	
	public void cadastrar(Usuario usuario){
		//String sql = "insert into Usuario (id,nome, login, senha) values (ID.NEXTVAL,?,?,?)";
		String sql = "insert into Usuario (nome, login, senha) values (?,?,?)";
		
		try {
			//Criando um statement
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			
			// executa a query sql de insert no banco
			preparador.execute();
			// encerrando o objeto do preparador
			preparador.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	public void alterar(Usuario usuario) {
		String sql = "update Usuario set nome=?, login=?, senha=? where id=?";
		try {
			//Criando um statement
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());
			
			// executa a query sql de insert no banco
			preparador.execute();
			// encerrando o objeto do preparador
			preparador.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void exclui(Usuario usuario) {
		String sql = "delete from Usuario where id=?";
		try {
			//Criando um statement
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, usuario.getId());
			
			// executa a query sql de insert no banco
			preparador.execute();
			// encerrando o objeto do preparador
			preparador.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void salva(Usuario usuario){
		if(usuario.getId()!=null && usuario.getId() > 0 ){
			alterar(usuario);
		}else{
			cadastrar(usuario);
		}
	}
	
	public Usuario buscaPorId(Integer id){
		String sql = "select * from usuario where id=?";
		try {
			//Criando um statement
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1,id);
			// executa a query sql de insert no banco e retorna um objeto do tipo ResultSet
			ResultSet resultado = preparador.executeQuery();
			//Posicionando o ponterio para o primeiro registro, um loop até encontrar mais registro na tabela
			if(resultado.next()){
				//criando uma instacia de usuario com os dados retornado pela consulta(RESULTSET)
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
				return usuario; // retorna o objeto usuario
			}
			// encerrando o objeto do preparador
			preparador.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Usuario> buscaTodos(){
		String sql = "select * from usuario";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			//Criando um statement
			PreparedStatement preparador = con.prepareStatement(sql);
			// executa a query sql de insert no banco e retorna um objeto do tipo ResultSet
			ResultSet resultado = preparador.executeQuery();
			
			//Posicionando o ponterio para o primeiro registro, um loop até encontrar mais registro na tabela
			while(resultado.next()){
				//criando uma instacia de usuario com os dados retornado pela consulta(RESULTSET)
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
				usuarios.add(usuario);
			}
			// encerrando o objeto do preparador
			preparador.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public Usuario autenticar(String login, String senha){
		String sql = "select * from usuario where login=? and senha=?";
		try{
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1,login);
			preparador.setString(2,senha);
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()){
				Usuario usuarioRetorno = new Usuario();
				usuarioRetorno.setId(resultado.getInt("id"));
				usuarioRetorno.setNome(resultado.getString("nome"));
				usuarioRetorno.setLogin(resultado.getString("login"));
				usuarioRetorno.setSenha(resultado.getString("senha"));
			
				return usuarioRetorno;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
				
		
	}

}
