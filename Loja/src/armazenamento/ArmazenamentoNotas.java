package armazenamento;

import java.util.Scanner;

import nota.*;
import cliente.*;
import produto.*;

public class ArmazenamentoNotas extends Armazenamento {
	private Nota notas[] = new Nota[MAX];
	private Scanner scanner = new Scanner(System.in);

	public void criarNota(ArmazenamentoClientes c, ArmazenamentoProdutos p) {
		System.out.println("\n--- Criar Nota de Compra -- (DIGITE SAIR PARA CANCELAR A OPERAÇÃO)");

		if(c.getEstoque() == 0){
			System.out.println("Erro: Não há clientes cadastrados para criar uma nota.");
			return;
		}

		Cliente cliente;
		boolean verificaCampo = false;
		do {
			c.listarClientes();
			System.out.print("Digite o ID do cliente: ");
			String inputIdCliente = scanner.nextLine();
			if (inputIdCliente.equalsIgnoreCase("SAIR")) return; // VERIFICA SE O USUÁRIO QUER SAIR
			
			if(inputIdCliente.isBlank()){
				System.out.println("Campo Vazio!! Tente Novamente"); // VERIFICA SE O CAMPO ESTÁ VAZIO
			} else {
		
					cliente = c.buscarPorId(Integer.parseInt(inputIdCliente));
					if (cliente == null) {
						System.out.println("Erro: Cliente não encontrado!"); // VERIFICA SE O CLIENTE EXISTE
					} else {
						verificaCampo = true;
					}
				}
		} while (!verificaCampo);
		cliente = c.buscarPorId(Integer.parseInt(scanner.nextLine()));

		if (estoque >= MAX) {
			System.out.println("Erro: Limite de notas fiscais atingido!");
			return;
		}

		Nota novaNota = new Nota(cliente, estoque + 1);
		String continuar;
		do {
			if (!p.listarProdutos()) {
				System.out.println("Não há produtos para adicionar. Finalizando a nota.");
				break;
			}
			
			Produto produto = null;
			verificaCampo = false;
			
			do{
				System.out.print("Digite o ID do produto para adicionar: ");
				String idProdutoInput = scanner.nextLine();
				if(idProdutoInput.equalsIgnoreCase("SAIR")) return;

				if(idProdutoInput.isBlank()){
					System.out.println("Campo Vazio!! Tente Novamente");
				} else {
						produto = p.buscarPorId(Integer.parseInt(idProdutoInput));
						if(produto == null){
							System.out.println("Erro: Produto não encontrado.");
						} else {
							verificaCampo = true;
						}
				}
			} while(!verificaCampo);

			int quantidade = 0;
			verificaCampo = false;
			do{
				System.out.print("Digite a quantidade: ");
				String quantidadeInput = scanner.nextLine();
				if(quantidadeInput.equalsIgnoreCase("SAIR")) return;
				
				if(quantidadeInput.isBlank()){
					System.out.println("Campo Vazio!! Tente Novamente");
				} else {
					try {
						quantidade = Integer.parseInt(quantidadeInput);
						if (quantidade > produto.getQuantidade()) {
							System.out.println("A quantidade desejada é maior que a quantidade em estoque");
						} else if (quantidade <= 0) {
							System.out.println("A quantidade deve ser um número positivo.");
						} else {
							verificaCampo = true;
						}
					} catch(NumberFormatException e){
						System.out.println("Quantidade inválida. Por favor, digite um número.");
					}
				}
			} while(!verificaCampo);
			
			ItemNota item = new ItemNota(produto, quantidade);
			novaNota.adicionarItem(item);
			System.out.println("Item adicionado!");

			do {
				System.out.print("Adicionar outro item? (s/n): ");
				continuar = scanner.nextLine();
				if (continuar.isBlank()) {
					System.out.println("Campo Vazio!! Tente Novamente");
				}
			} while (continuar.isBlank());

		} while (continuar.equalsIgnoreCase("s"));

			this.notas[estoque++] = novaNota;
			novaNota.exibirResumo();
			System.out.println("Nota criada com sucesso!");
	}

	public void listarNotasEmitidas() {
		System.out.println("\n--- Notas Fiscais Emitidas ---");
		if (estoque == 0) {
			System.out.println("Nenhuma nota foi emitida ainda.");
		} else {
			for (int i = 0; i < estoque; i++) {
				notas[i].exibirResumo();
			}
		}
	}
}