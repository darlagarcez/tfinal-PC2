package br.com.prog2.tfinal.view;

import java.sql.Connection;
import br.com.prog2.tfinal.persistencia.ConnectionFactory;
public class Teste {
	public static void main(String[] args) {
		Connection con = ConnectionFactory.getConnection();
		
		if(con != null){
			System.out.println("OK");
			ConnectionFactory.close(con);
		}
	}
}
