package exemploBancoDados;

import java.sql.Connection;
import java.sql.DriverManager;

public class TesteConexao {
	
	public static void main(String[] args) {
		
		try {
			 
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_heiser?useSSL=false&serverTimezone=UTC",
		 "root",
		 "root"
		 );
		 
		System.out.println("Conectado com sucesso!");

		} catch (Exception e) {
			
		 System.out.println("Erro: " + e.getMessage());
		 
		}
	}
}