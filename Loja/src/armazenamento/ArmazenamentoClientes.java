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

		System.out.println("--CADASTRANDO CLIENTE-- (DIGITE SAIR PARA CANCELAR A OPERAÇÃO)");

		String inputId;
		boolean verificaCampo = false;
		do {
			System.out.println("Insira o ID: ");
			inputId = scanner.nextLine();
			if (inputId.equalsIgnoreCase("SAIR")) return; // VERIFICA SE O USUÁRIO QUER SAIR
			if (inputId.isBlank()) {
				System.out.println("Campo Vazio!! Tente Novamente"); // VERIFICA SE O CAMPO ESTÁ VAZIO
			} else {
					if (buscarPorId(Integer.parseInt(inputId)) != null) { // VERIFICA SE O ID JÁ EXISTE
						System.out.println("ID já cadastrado. Tente outro.");
					} else {
						verificaCampo = true;
					}
			}
		} while (!verificaCampo);
		
		String nome;
		do {
			System.out.println("Insira o Nome: ");
			nome = scanner.nextLine();
			if (nome.equalsIgnoreCase("SAIR")) return;
			if (nome.isBlank()) {
				System.out.println("Campo Vazio!! Tente Novamente");
			}
		} while (nome.isBlank());

		String endereco;
		do {
			System.out.println("Insira o Endereço: ");
			endereco = scanner.nextLine();
			if (endereco.equalsIgnoreCase("SAIR")) return;
			if (endereco.isBlank()) {
				System.out.println("Campo Vazio!! Tente Novamente");
			}
		} while (endereco.isBlank());
		String telefone;
		do {
			System.out.println("Insira o Telefone: ");
			telefone = scanner.nextLine();
			if (telefone.equalsIgnoreCase("SAIR")) return;
			if (telefone.isBlank()) {
				System.out.println("Campo Vazio!! Tente Novamente");
			}
		} while (telefone.isBlank());

		String inputTipo;
		int tipo;
		verificaCampo = false;
		do {
			System.out.println("Insira o Tipo (1 - Pessoa Física | 2 - Pessoa Jurídica): ");
			inputTipo = scanner.nextLine();
			if (inputTipo.equalsIgnoreCase("SAIR")) return;
			if(inputTipo.isBlank()){
				System.out.println("Campo Vazio!! Tente Novamente");
			} else {
				try {
					tipo = Integer.parseInt(inputTipo);
					if (tipo < 1 || tipo > 2) {
						System.out.println("Não há esse tipo, digite novamente!");
					} else {
						verificaCampo = true;
					}
				} catch (NumberFormatException e) {
					System.out.println("Entrada inválida. Por favor, insira 1 ou 2.");
				}
			}
		} while (!verificaCampo);
		
		tipo = Integer.parseInt(inputTipo);

		if (tipo == 1) {
			String cpf;
			do {
				System.out.println("Insira o CPF: ");
				cpf = scanner.nextLine();
				if (cpf.equalsIgnoreCase("SAIR")) return;
				if (cpf.isBlank()) {
					System.out.println("Campo Vazio!! Tente Novamente");
				}
			} while (cpf.isBlank()); //UPCAST EXPLÍCITO
			clientes[estoque++] = (Cliente) new PessoaFisica(Integer.parseInt(inputId), nome, endereco, telefone, cpf);
		
		} else if (tipo == 2) {
			String cnpj;
			do {
				System.out.println("Insira o CNPJ: ");
				cnpj = scanner.nextLine();
				if (cnpj.equalsIgnoreCase("SAIR")) return;
				if (cnpj.isBlank()) {
					System.out.println("Campo Vazio!! Tente Novamente");
				}
			} while (cnpj.isBlank()); //UPCAST EXPLÍCITO
			clientes[estoque++] = (Cliente) new PessoaJuridica(Integer.parseInt(inputId), nome, endereco, telefone, cnpj);
		}

		System.out.println("Cliente cadastrado com sucesso!");
	}

	public void listarClientes() {
		System.out.println("\n--- Lista de Clientes (com Downcast) ---");
		for (int i = 0; i < estoque; i++) {
			Cliente c = clientes[i];

			if (c instanceof PessoaFisica) {
				// DOWNCAST
				PessoaFisica pf = (PessoaFisica) c;
				System.out.printf("ID: %d | Nome: %s | Tipo: %s | CPF: %s\n", pf.getId(), pf.getNome(), pf.getTipo(),
						pf.getCpf());

			} else if (c instanceof PessoaJuridica) {
				// DOWNCAST
				PessoaJuridica pj = (PessoaJuridica) c;
				System.out.printf("ID: %d | Nome: %s | Tipo: %s | CNPJ: %s\n", pj.getId(), pj.getNome(), pj.getTipo(),
						pj.getCnpj());
			}
		}
	}

	public void alterarCliente() {
		if (estoque == 0) {
			System.out.println("Não há clientes cadastrados!");
			return;
		}

		Cliente clienteAlterado;
		boolean verificaCampo = false;
		String idAlterado;
		do {
			listarClientes();
			System.out.println("--ALTERANDO CLIENTE-- (DIGITE SAIR PARA CANCELAR A OPERAÇÃO)");
			System.out.println("Digite o ID do cliente a ser alterado: ");
			idAlterado = scanner.nextLine();

			if (idAlterado.equalsIgnoreCase("SAIR")) { return; }
			if (idAlterado.isBlank()) {
				System.out.println("Campo Vazio!! Tente Novamente");
			} else {  //VERIFICA SE O ID INSERIDO É VÁLIDO, CASO NÃO, PEDE PARA INSERIR NOVAMENTE
					if (buscarPorId(Integer.parseInt(idAlterado)) == null) {
						System.out.println("ID INVÁLIDO");
					} else {
						verificaCampo = true;
					}
			}
		} while (!verificaCampo);
		clienteAlterado = buscarPorId(Integer.parseInt(idAlterado));

		System.out.println("O que deseja alterar do cliente? (1 - Telefone | 2 - Endereço)");
		int alteracao = Integer.parseInt(scanner.nextLine());

		if (alteracao == 1) {
			String novoTelefone;
			do {
				System.out.println("Digite o novo telefone:");
				novoTelefone = scanner.nextLine();
				if (novoTelefone.isBlank()) {
					System.out.println("Campo Vazio!! Tente Novamente");
				}
			} while (novoTelefone.isBlank());
			clienteAlterado.setTelefone(novoTelefone);
			System.out.println("Telefone alterado com sucesso!");
		
		} else if (alteracao == 2) {
			String novoEndereco;
			do {
				System.out.println("Digite o novo endereço:");
				novoEndereco = scanner.nextLine();
				if (novoEndereco.isBlank()) {
					System.out.println("Campo Vazio!! Tente Novamente");
				}
			} while (novoEndereco.isBlank());
			clienteAlterado.setEndereco(novoEndereco);
			System.out.println("Endereco alterado com sucesso!");
		
		} else {
			System.out.println("OPÇÃO INVALIDA!");
		}
	}
}