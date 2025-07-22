package armazenamento;

import java.util.Scanner;

import nota.*;
import cliente.*;
import produto.*;

public class ArmazenamentoNotas extends Armazenamento {
	private Nota notas[] = new Nota[MAX];
	private int emissoes = 0;
	private Scanner scanner = new Scanner(System.in);

	public void criarNota(ArmazenamentoClientes c, ArmazenamentoProdutos p) {
		System.out.println("\n--- Criar Nota de Compra ---");

		c.listarClientes();
		System.out.print("Digite o ID do cliente: ");
		int idCliente = Integer.parseInt(scanner.nextLine());
		Cliente cliente = c.buscarPorId(idCliente);

		if (cliente == null) {
			System.out.println("Erro: Cliente não encontrado!");
			return;
		}

		if (emissoes >= MAX) {
			System.out.println("Erro: Limite de notas fiscais atingido!");
			return;
		}

		Nota novaNota = new Nota(cliente, emissoes + 1);

		String continuar;
		do {
			p.listarProdutos();
			System.out.print("Digite o ID do produto para adicionar: ");
			int idProduto = Integer.parseInt(scanner.nextLine());
			Produto produto = p.buscarPorId(idProduto);

			if (produto != null) {
				System.out.print("Digite a quantidade: ");
				int quantidade = Integer.parseInt(scanner.nextLine());
				if (quantidade > produto.getQuantidade()) {
					System.out.println(" A quantidade desejada é maior que a quantidade em estoque");
					return;
				}

				ItemNota item = new ItemNota(produto, quantidade);
				novaNota.adicionarItem(item);
				System.out.println("Item adicionado!");
			} else {
				System.out.println("Erro: Produto não encontrado.");
			}

			do {
				System.out.print("Adicionar outro item? (s/n): ");
				continuar = scanner.nextLine();
				if (continuar.isBlank()) {
					System.out.println("Campo Vazio!! Tente Novamente");
				}
			} while (continuar.isBlank());

		} while (continuar.equalsIgnoreCase("s"));

		this.notas[emissoes++] = novaNota;
		novaNota.exibirResumo();
		System.out.println("Nota criada com sucesso!");
	}

	public void listarNotasEmitidas() {
		System.out.println("\n--- Notas Fiscais Emitidas ---");
		if (emissoes == 0) {
			System.out.println("Nenhuma nota foi emitida ainda.");
		} else {
			for (int i = 0; i < emissoes; i++) {
				notas[i].exibirResumo();
			}
		}
	}
}