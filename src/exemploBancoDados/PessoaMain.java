package exemploBancoDados;

import java.util.*;

public class PessoaMain {

	public static void main(String[] args) {

		Scanner imput = new Scanner(System.in);
		
		try {
			
			System.out.print("Informe seu nome: ");
			String nomePessoa = imput.nextLine();
			
			System.out.print("Informe sua idade: ");
			int idadePessoa = imput.nextInt();
			
			Pessoa natalino = new Pessoa(nomePessoa, idadePessoa);
			
			PessoaDAO pessoa = new PessoaDAO();
			pessoa.inserir(natalino);
			
		}catch(Exception e) {
			
			System.out.println("Erro no banco: " + e.getMessage());
			
		}
		
	}
}