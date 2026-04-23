package crudProduto;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import crudProduto.Produto;
import crudProduto.ProdutoDAO;

public class Main {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        int opcao;
        
        do {
        	
            System.out.println("--MENU CRUD--");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Listar produto");
            System.out.println("3. Atualizar produto");
            System.out.println("4. Deletar produto");
            System.out.println("0. Sair");
            System.out.print("Digite sua escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao) {
            
            case 1:
            	
                try {
                	
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    
                    System.out.print("Preço: ");
                    int quantidade = sc.nextInt();
                    sc.nextLine();
                    
                    Produto novoProduto = new Produto(nome, preco, quantidade);
                    produtoDAO.inserir(novoProduto);
                    
                }catch(SQLException e) {
                	
                    System.out.println("Erro ao inserir: "+ e.getMessage());
                    
                }
                
                break;
                
            case 2:
            	
                try {
                	
                    List<Produto> lista = produtoDAO.listar();
                    
                    if(lista.isEmpty()) {
                    	
                        System.out.println("Nenhum produto cadastrad.");
                    }else {
                    	
                        System.out.println("Pessoas cadastradas");
                        
                        for(Produto produto : lista) {
                        	
                            System.out.println(produto);
                            
                        }
                        
                    }
                    
                }catch(SQLException e) {
                	
                    System.out.println("Erro em fazer a lista: " + e.getMessage());
                }
                
                break;
                
            case 3:
            	
                try {
                	
                    System.out.println("ID do produto: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Novo nome:  ");
                    String novoNome = sc.nextLine();
            
                    System.out.print("Novo nome:  ");
                    double novoPreco = sc.nextDouble();
                    
                    System.out.print("Nova quantidade: ");
                    int novaQuantidade = sc.nextInt();
                    sc.nextLine();
                    
                    Produto atualizarProduto = new Produto(idAtualizar, novoNome, novoPreco, novaQuantidade);
                    produtoDAO.atualizar(atualizarProduto);
                    
                }catch(SQLException e) {
                	
                    System.out.println("Erro ao inserir: "+ e.getMessage());
                    
                }
                
                break;
                
            case 4: 
            	
                try {
                	
                    System.out.println("ID para excluir: ");
                    int idExcluir = sc.nextInt();
                    sc.nextLine();
                    
                    produtoDAO.excluir(idExcluir);
                    
                }catch(SQLException e) {
                	
                    System.out.println("Erro ao excluir: "+ e.getMessage());
                    
                }
                
            }
            
        }while(opcao != 0);
        
	}
}