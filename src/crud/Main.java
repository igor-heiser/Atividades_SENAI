package crud;

import java.sql.SQLException;
import java.util.*;

public class Main {

	public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        PessoasDAO pessoaDAO = new PessoasDAO();
        
        int opcao;
        
        do {
            System.out.println("--MENU CRUD--");
            System.out.println("1. Adicionar pessoa");
            System.out.println("2. Listar pessoas");
            System.err.println("3. Atualizar dados");
            System.out.println("4. Deletar dados");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao=leia.nextInt();
            leia.nextLine();
            
            switch(opcao) {
            
            case 1:
                try {
                    System.out.println("--Adicionando Pessoa--");
                    System.out.print("Nome: ");
                    String nome = leia.nextLine();
                    
                    System.out.print("Idade: ");
                    int idade = leia.nextInt();
                    
                    Pessoas novaPessoa = new Pessoas(nome,idade);
                    pessoaDAO.inserir(novaPessoa);
                    
                }catch(SQLException e) {
                    System.out.println("Erro ao inserir: "+ e.getMessage());
                }
                
                break;
                
            case 2:
                try {
                    List<Pessoas> lista = pessoaDAO.listar();
                    
                    if(lista.isEmpty()) {
                        System.out.println("Nenhuma pessoa cadastrada.");
                    }else {
                        System.out.println("Pessoas cadastradas");
                        for(Pessoas per:lista) {
                            System.out.println(per);
                        }
                    }
                }catch(SQLException e) {
                    System.out.println("Erro em fazer a lista: " + e.getMessage());
                }
                break;
                
            case 3:
                try {
                    System.out.println("ID da pessoa: ");
                    int idAtualizar = leia.nextInt();
                    leia.nextLine();
                    
                    System.out.print("Novo Nome:  ");
                    String novoNome = leia.nextLine();
            
                    System.out.print("Nova Idade: ");
                    int novaIdade = leia.nextInt();
                    
                    Pessoas pessoaAtualizar = new Pessoas(idAtualizar,novoNome,novaIdade);
                    pessoaDAO.atualizar(pessoaAtualizar);
                    
                }catch(SQLException e) {
                    System.out.println("Erro ao inserir: "+ e.getMessage());
                }
                break;
                
            case 4: 
                try {
                    System.out.println("ID para excluir: ");
                    int idExcluir = leia.nextInt();
                    leia.nextLine();
                    
                    pessoaDAO.excluir(idExcluir);
                    
                }catch(SQLException e) {
                    System.out.println("Erro ao excluir: "+ e.getMessage());
                }
            }
        }while(opcao != 0);
    }

}