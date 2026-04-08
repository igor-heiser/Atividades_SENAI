package exemploBancoDados;

public class Pessoa {

	private int id;
	private String nome;
	private int idade;
	private String cpf;
	
	//contrutor sem ID (será criado pelo banco)
	public Pessoa(String nome, int idade, String cpf) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
	}

	//construtor para leitura (id já existe)
	public Pessoa(int id, String nome, int idade, String cpf) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Pessoa [ id = " + id + ", nome = " + nome + ", idade = " + idade + ", cpf = " + cpf + " ]";
	}	
	
}