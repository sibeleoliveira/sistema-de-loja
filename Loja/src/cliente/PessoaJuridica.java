package cliente;

public class PessoaJuridica extends Cliente {
	 private String cnpj;
	 private String tipo = "Pessoa Jurídica";

	    public PessoaJuridica(String id, String nome, String endereco, String telefone, String cnpj) {
	        super(id, nome, endereco, telefone);
	        this.cnpj = cnpj;
	    }

	    public String getCnpj() { return cnpj; }

	    public String getTipo() {
	        return this.tipo;
	    }
	
}
