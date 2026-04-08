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
			imput.nextLine();
			
			System.out.println("Informe seu CPF: ");
			String cpfPessoa = imput.nextLine();
			
			Pessoa natalino = new Pessoa(nomePessoa, idadePessoa, cpfPessoa);
			
			PessoaDAO natalinoDAO = new PessoaDAO();
			natalinoDAO.inserir(natalino);
			
			//leitura do banco de dados
			List<Pessoa> lista = natalinoDAO.listar();
			
			for(Pessoa p : lista) {
				System.out.println(p);
			}
			
		}catch(Exception e) {
			
			System.err.println("Erro no banco: " + e.getMessage());
			
		}
		
	}
}