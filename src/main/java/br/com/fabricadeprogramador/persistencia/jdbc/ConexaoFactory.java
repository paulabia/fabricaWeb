package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	// realiza uma conexão com o banco
	public static Connection getConnection() {
		
		  try { Class.forName("oracle.jdbc.driver.OracleDriver"); return
		  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
		  "fabricaweb", "fabricaweb");
		  
		  } catch (SQLException e) { throw new RuntimeException(e); } catch
		  (ClassNotFoundException e) { // TODO Auto-generated catch block
		  e.printStackTrace(); } return null; }
	/*	 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/fabricaweb", "root", "");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}*/

}
