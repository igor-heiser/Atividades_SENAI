package exemploBancoDados;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class PessoaDAO {

	//create
	public void inserir(Pessoa p) throws SQLException{
		
		String sql = "INSERT INTO pessoas(nome, idade) VALUES (?, ?)";
		
		//try com recursos
		try (Connection conn = Conexao.conectar();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			
			stmt.setString(1, p.getNome());
			stmt.setInt(2, p.getIdade());
			
			stmt.executeUpdate();
			System.out.println("Pessoa adicionada com SUCESSO!");
		}
		
	}
}