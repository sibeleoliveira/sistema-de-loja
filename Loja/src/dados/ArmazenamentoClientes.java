package dados;

import java.util.Scanner;
import cliente.Cliente;
import cliente.PessoaFisica;
import cliente.PessoaJuridica;

public class ArmazenamentoClientes {
	 private static final int MAX_CLIENTES = 100;
	    private Cliente[] clientes = new Cliente[MAX_CLIENTES];
	    private int contador = 0;
	    private Scanner scanner = new Scanner(System.in);
	    
	    public Cliente buscarPorId(String id) {
	        for (int i = 0; i < contador; i++) {
	            if (clientes[i].getId().equals(id)) {
	            	return clientes[i];
	            }
	        }
	        return null;
	    }

	    public void cadastrarCliente() {
	        if (contador >= MAX_CLIENTES) {
	            System.out.println("Limite máximo de clientes atingido!");
	            return;
	        }

	        System.out.println("Cadastrar Cliente:");
	        System.out.println("Tipo (1 - Pessoa Física | 2 - Pessoa Jurídica): ");
	        int tipo = Integer.parseInt(scanner.nextLine());

	        String id;
	        while (true) {
	            System.out.print("ID: ");
	            id = scanner.nextLine();
	            if (buscarPorId(id) != null) {
	                System.out.println("ID já cadastrado. Tente outro.");
	            } else {
	                break;
	            }
	        }

	        System.out.println("Nome: ");
	        String nome = scanner.nextLine();

	        System.out.println("Endereço: ");
	        String endereco = scanner.nextLine();

	        System.out.println("Telefone: ");
	        String telefone = scanner.nextLine();

	        if (tipo == 1) {
	            System.out.println("CPF: ");
	            String cpf = scanner.nextLine();
	            clientes[contador++] = new PessoaFisica(id, nome, endereco, telefone, cpf);
	        } else if (tipo == 2) {
	            System.out.println("CNPJ: ");
	            String cnpj = scanner.nextLine();
	            clientes[contador++] = new PessoaJuridica(id, nome, endereco, telefone, cnpj);
	        } else {
	            System.out.println("Tipo inválido!");
	        }

	        System.out.println("Cliente cadastrado com sucesso!");
	    }

	    public void listarClientes() {
	        System.out.println("\n--- Lista de Clientes ---");
	        for (int i = 0; i < contador; i++) {
	            Cliente c = clientes[i];
	            System.out.printf("%s - %s (%s)\n", c.getId(), c.getNome(), c.getTipo());
	        }
	    }
}
