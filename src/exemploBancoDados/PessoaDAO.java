package exemploBancoDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class PessoaDAO {

	//create
	public void inserir(Pessoa p) throws SQLException{
		
		String sql = "INSERT INTO pessoas(nome, idade, cpf) VALUES (?, ?, ?)";
		
		//try com recursos
		try (Connection conn = Conexao.conectar();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			
			stmt.setString(1, p.getNome());
			stmt.setInt(2, p.getIdade());
			stmt.setString(3, p.getCpf());
			
			stmt.executeUpdate();
			System.out.println("Pessoa adicionada com SUCESSO!");
			
			}
		}
		
		//Read listar todas as pessoas
		public List<Pessoa> listar() throws SQLException{
					
			List<Pessoa> lista = new ArrayList<>();
			String sql = "SELECT * FROM pessoas";
			
			try (Connection conn = Conexao.conectar();
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql)){
				
				while (rs.next()) {
					lista.add(new Pessoa(
							rs.getInt("id"),
							rs.getString("nome"),
							rs.getInt("idade"),
							rs.getString("cpf")
							));
				}
				
				return lista;

			}
							
	}
}