package armazenamento;

import java.util.Scanner;
import cliente.Cliente;
import cliente.PessoaFisica;
import cliente.PessoaJuridica;

public class ArmazenamentoClientes extends Armazenamento {
	protected static final int MAX = 100;
	private Cliente[] clientes = new Cliente[MAX];
	private Scanner scanner = new Scanner(System.in);

	public Cliente buscarPorId(int id) {
		for (int i = 0; i < estoque; i++) {
			if (clientes[i].getId() == id) {
				return clientes[i];
			}
		}
		return null;
	}

	public void cadastrarCliente() {
		if (estoque == MAX) {
			System.out.println("Limite máximo atingido!");
			return;
		}

		System.out.println("--CADASTRANDO CLIENTE--");

		int id;
		do {
			System.out.println("Insira o ID: ");
			id = Integer.parseInt(scanner.nextLine());
			if (buscarPorId(id) != null) {
				System.out.println("ID já cadastrado. Tente outro.");
			}
		} while (buscarPorId(id) != null);
		
		String nome;
		do {
			System.out.println("Insira o Nome: ");
			nome = scanner.nextLine();
			if(nome.isBlank()) {
				System.out.println("Campo Vazio!! Tente Novamente");
			}
		} while(nome.isBlank());

		String endereco;
		do {
			System.out.println("Insira o Endereço: ");
			endereco = scanner.nextLine();
			if(endereco.isBlank()) {
				System.out.println("Campo Vazio!! Tente Novamente");
			}
		} while(endereco.isBlank());

		String telefone;
		do {
			System.out.println("Insira o Telefone: ");
			telefone = scanner.nextLine();
			if(telefone.isBlank()) {
				System.out.println("Campo Vazio!! Tente Novamente");
			}
		} while(telefone.isBlank());

		System.out.println("Insira o Tipo (1 - Pessoa Física | 2 - Pessoa Jurídica): ");
		int tipo = Integer.parseInt(scanner.nextLine());

		if (tipo == 1) {
			String cpf;
			do {
				System.out.println("Insira o CPF: ");
				cpf = scanner.nextLine();
				if(cpf.isBlank()) {
					System.out.println("Campo Vazio!! Tente Novamente");
				}
			} while(cpf.isBlank());
			clientes[estoque++] = new PessoaFisica(id, nome, endereco, telefone, cpf);
		} else if (tipo == 2) {
			String cnpj;
			do {
				System.out.println("Insira o CNPJ: ");
				cnpj = scanner.nextLine();
				if(cnpj.isBlank()) {
					System.out.println("Campo Vazio!! Tente Novamente");
				}
			} while(cnpj.isBlank());
			clientes[estoque++] = new PessoaJuridica(id, nome, endereco, telefone, cnpj);
		} else {
			System.out.println("Tipo inválido!");
			return;
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

	public void alterarCliente() {
		System.out.println("Digite o ID do cliente a ser alterado:");
		int id;
		id = Integer.parseInt(scanner.nextLine());
		Cliente c = buscarPorId(id);
		if (c == null) {
			System.out.println("ID invalido!");
			return;
		}
		System.out.println("O que deseja alterar do cliente(1 - Telefone | 2 - Endereço)");
		int alteracao;
		alteracao = Integer.parseInt(scanner.nextLine());
		if (alteracao == 1) {
			String telefone;
			do {
				System.out.println("Digite o novo telefone:");
				telefone = scanner.nextLine();
				if (telefone.isBlank()) {
					System.out.println("Campo Vazio!! Tente Novamente");
				}
			} while(telefone.isBlank());
			c.setTelefone(telefone);
			System.out.println("Telefone alterado com sucesso!");
		} else if (alteracao == 2) {
			String endereco;
			do {
				System.out.println("Digite o novo endereço:");
				endereco = scanner.nextLine();
				if (endereco.isBlank()) {
					System.out.println("Campo Vazio!! Tente Novamente");
				}
			} while(endereco.isBlank());
			
			c.setEndereco(endereco); 
			System.out.println("Endereco alterado com sucesso!");

		} else
			System.out.println("OPÇÃO INVALIDA!");
	}
}