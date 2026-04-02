package exemploBancoDados;

public class Pessoa {

	private int id;
	private String nome;
	private int idade;
	
	//contrutor sem ID (será criado pelo banco)
	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	//construtor para leitura (id já existe)
	public Pessoa(int id, String nome, int idade) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
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

	//método toString
	@Override
	public String toString() {
		return "Pessoa [ id = " + id + ", nome = " + nome + ", idade = " + idade + " ]";
	}	
	
}