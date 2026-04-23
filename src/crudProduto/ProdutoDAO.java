package crudProduto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import crud.Pessoas;
import exemploBancoDados.Conexao;

public class ProdutoDAO {

	//inserir
    public void inserir(Produto p)throws SQLException{
        String sql ="INSERT INTO produtos(nome, preco, quantidade) values(?, ?, ?)";
            
            try(Connection conn = Conexao.conectar();
                    
                    PreparedStatement stmt = conn.prepareStatement(sql)){
                
                stmt.setString(1, p.getNome());
                stmt.setDouble(2, p.getPreco());
                stmt.setInt(3, p.getQuantidade());
                
                stmt.executeUpdate();
                System.out.println("Produto adicionda com sucesso!");
            }
    }
    
    //read
    public List<Produto> listar()throws SQLException{
        
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        
        try (Connection conn = Conexao.conectar();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
                    
            while (rs.next()) {
                lista.add(new Produto(rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getDouble("preco"),
                            rs.getInt("quantidade")
                        ));
                
                
            }
            return lista;
    }
}
    
    // update
    
    public void atualizar(Produto p) throws SQLException{
        String sql = "UPDATE pessoas SET nome = ?, idade = ? where id=?";
        
        try(Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)){
        
                    stmt.setString(1, p.getNome());
                    stmt.setDouble(2, p.getPreco());
                    stmt.setInt(3, p.getQuantidade());

                    stmt.executeUpdate();
                    System.out.println("Dados atualizados!");
                    
        }
    }
    
    //excluir/delete
    
    public void excluir(int id) throws SQLException{
        String sql = "DELETE from produtos where id= ?";
        
        try(Connection conn = Conexao.conectar();
                PreparedStatement stmt = conn.prepareStatement(sql)){
                    
            stmt.setInt(1, id);
            
            stmt.executeUpdate();
            System.out.println("Dados excluidos!");
                }
    }
    
}
