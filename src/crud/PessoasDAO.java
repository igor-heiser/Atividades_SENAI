package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exemploBancoDados.Conexao;
import exemploBancoDados.Pessoa;

public class PessoasDAO {

	//create
		public void inserir(Pessoas p) throws SQLException{
			
			String sql = "INSERT INTO people(nome, idade) VALUES (?, ?)";
			
			//try com recursos
			try (Connection conn = Conexao.conectar();
					PreparedStatement stmt = conn.prepareStatement(sql)){
				
				stmt.setString(1, p.getNome());
				stmt.setInt(2, p.getIdade());
				
				stmt.executeUpdate();
				System.out.println("Pessoa adicionada com SUCESSO!");
				
				}
			}
			
			//Read listar todas as pessoas
			public List<Pessoas> listar() throws SQLException{
						
				List<Pessoas> lista = new ArrayList<>();
				String sql = "SELECT * FROM people";
				
				try (Connection conn = Conexao.conectar();
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(sql)){
					
					while (rs.next()) {
						lista.add(new Pessoas(
								rs.getInt("id"),
								rs.getString("nome"),
								rs.getInt("idade")
								));
					}
					
					return lista;

				}
								
		}
			
		//update (Atualizar) nome e idade pelo ID
		
			public void atualizar(Pessoas p) throws SQLException{
				
				String sql = "UPDATE people SET nome = ?, idade = ? WHERE id = ?";
				
			}
			
		
			
}