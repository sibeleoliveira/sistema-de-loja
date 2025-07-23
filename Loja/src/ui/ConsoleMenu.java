package ui;

import armazenamento.*;
import java.util.Scanner;

public class ConsoleMenu implements Menu {
	private String input;
	private ArmazenamentoClientes clientes = new ArmazenamentoClientes();
	private ArmazenamentoProdutos produtos = new ArmazenamentoProdutos();
	private ArmazenamentoNotas notas = new ArmazenamentoNotas();
	private Scanner scanner = new Scanner(System.in);

	
	//implementação da interface 
	public void play() {
		boolean verificaSaida = false; 
		do {

			System.out.println("--Menu Principal--");
			System.out.println("1 - Cadastrar Produto     2 - Alterar Produto");
			System.out.println("3 - Cadastrar Cliente     4 - Alterar Cliente");
			System.out.println("5 - Criar Nota de Compra  6 - Listar Notas Emitidas");
			System.out.println("7 - Listar Produtos       8 - Listar Clientes");
			System.out.println("0 - Sair");

			input = scanner.nextLine();

			if(input.isBlank()){
				System.out.println("Campo Vazio!! Tente Novamente");
			} else if (Integer.parseInt(input) == 1) {
				produtos.cadastrarProduto();
			} else if (Integer.parseInt(input) == 2) {
				produtos.alterarProduto();
			} else if (Integer.parseInt(input) == 3) {
				clientes.cadastrarCliente();
			} else if (Integer.parseInt(input) == 4) {
				clientes.alterarCliente();
			} else if (Integer.parseInt(input) == 5) {
				notas.criarNota(clientes,produtos);
			} else if (Integer.parseInt(input) == 6) {
				notas.listarNotasEmitidas();
			} else if (Integer.parseInt(input) == 7) {
				produtos.listarProdutos();
			} else if (Integer.parseInt(input) == 8) {
				clientes.listarClientes();
			} else if (Integer.parseInt(input) == 0) {
				System.out.println("SAINDO...");
				verificaSaida = true;
			} else{
				System.out.println("OPÇÃO INVÁLIDA! TENTE NOVAMENTE");
			}

		} while (!verificaSaida);

	}

}
