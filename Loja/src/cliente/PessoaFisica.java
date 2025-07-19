package cliente;

public class PessoaFisica extends Cliente{
	 private String cpf;
	 private String tipo = "Pessoa Fisíca";

	    public PessoaFisica(String id, String nome, String endereco, String telefone, String cpf) {
	        super(id, nome, endereco, telefone);
	        this.cpf = cpf;
	    }

	    public String getCpf() { return cpf; }

	    public String getTipo() {
	        return this.tipo;
	    }
}
