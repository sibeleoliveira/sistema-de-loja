package armazenamento;

import java.util.Scanner;
import cliente.Cliente;
import cliente.PessoaFisica;
import cliente.PessoaJuridica;

public class ArmazenamentoClientes extends Armazenamento{
	protected static final int MAX = 100;
	private Cliente[] clientes = new Cliente[MAX];
	private Scanner scanner = new Scanner(System.in);
	private int estoque = 0;
	
	public boolean buscarPorId(int id){
		for(int i = 0; i < estoque; i++){
			if(clientes[i].getId() == id){
				return true;
			}
		}
    	return false;
  	}

	public void cadastrarCliente() {
		if(estoque == MAX){
			System.out.println("Limite máximo atingido!");
			return;
		} 

		System.out.println("--CADASTRANDO CLIENTE--");

		int id;
		do {
			System.out.println("Insira o ID: ");
			id = Integer.parseInt(scanner.nextLine());
			if(buscarPorId(id)){
			System.out.println("ID já cadastrado. Tente outro.");
			}
		}while(buscarPorId(id));

		System.out.println("Insira o Nome: ");
		String nome = scanner.nextLine();

		System.out.println("Insira o Endereço: ");
		String endereco = scanner.nextLine();

		System.out.println("Insira o Telefone: ");
		String telefone = scanner.nextLine();

		System.out.println("Insira o Tipo (1 - Pessoa Física | 2 - Pessoa Jurídica): ");
		int tipo = Integer.parseInt(scanner.nextLine());

		if (tipo == 1) {
			System.out.println("Insira o CPF: ");
			String cpf = scanner.nextLine();
			clientes[estoque++] = new PessoaFisica(id, nome, endereco, telefone, cpf);
		} else if (tipo == 2) {
			System.out.println("Insira o CNPJ: ");
			String cnpj = scanner.nextLine();
			clientes[estoque++] = new PessoaJuridica(id, nome, endereco, telefone, cnpj);
		} else {
			System.out.println("Tipo inválido!");
		}

		System.out.println("Cliente cadastrado com sucesso!");
	}

	public void listarClientes() {
		System.out.println("\n--- Lista de Clientes ---");
		for (int i = 0; i < estoque; i++) {
			Cliente c = clientes[i];
			System.out.printf("%d - %s (%s)\n", c.getId(), c.getNome(), c.getTipo());
		}
	}
}
