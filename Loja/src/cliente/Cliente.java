package cliente;

public class Cliente {
	    protected String id;
	    protected String nome;
	    protected String endereco;
	    protected String telefone;

	    public Cliente(String id, String nome, String endereco, String telefone) {
	        this.id = id;
	        this.nome = nome;
	        this.endereco = endereco;
	        this.telefone = telefone;
	    }

	    public String getId() { return id; }
	    public String getNome() { return nome; }

	    public void setEndereco(String endereco) { this.endereco = endereco; }
	    public void setTelefone(String telefone) { this.telefone = telefone; }

	    public String getTipo() {
	    	return "";
	    };
}
