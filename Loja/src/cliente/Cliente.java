package cliente;

//Abstração da classe Cliente
abstract public class Cliente {
	    protected int id;
	    protected String nome;
	    protected String endereco;
	    protected String telefone;

	    public Cliente(int id, String nome, String endereco, String telefone) {
	        this.id = id;
	        this.nome = nome;
	        this.endereco = endereco;
	        this.telefone = telefone;
	    }

	    public int getId() { return id; }
	    public String getNome() { return nome; }

	    public void setEndereco(String endereco) { this.endereco = endereco; }
	    public void setTelefone(String telefone) { this.telefone = telefone; }

		//Abstração do método getTipo()
	    public abstract String getTipo();
}
