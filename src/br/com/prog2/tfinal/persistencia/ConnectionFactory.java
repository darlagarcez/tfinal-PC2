package br.com.prog2.tfinal.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() {
		String driver = "org.postgresql.Driver";
		String user = "tfinal"; // o usuário criado para acesso ao banco
		String senha = "123456"; // senha para acesso ao banco
		String url = "jdbc:postgresql://127.0.0.1:5449/tfinal"; // servidor onde está instalado o banco
		
		Connection conexao = null;
		
		try {
			Class.forName(driver);
			conexao = (Connection)DriverManager.getConnection(url, user, senha);
		} catch (ClassNotFoundException ex) {
			System.err.print(ex.getMessage());
		} catch (SQLException e) {
			System.err.print(e.getMessage());
		}
		return conexao;
	}
	public static void close(Connection conexao){
		try {
			conexao.close();
		} catch (SQLException e){}
	}
}
