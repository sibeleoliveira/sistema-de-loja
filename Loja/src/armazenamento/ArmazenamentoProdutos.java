
package armazenamento;

import produto.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class ArmazenamentoProdutos extends Armazenamento{
	protected static final int MAX = 100;
  	private Produto[] produtos = new Produto[MAX];
	private int estoque = 0;
  	private Scanner scanner = new Scanner(System.in);
	
	public boolean buscarPorId(int id){
		for(int i = 0; i < estoque; i++){
			if(produtos[i].getId() == id){
				return true;
			}
		}
    	return false;
  	}

  	public void cadastrarProduto(){
		if(estoque == MAX){
		System.out.println("Limite máximo atingido!");
		return;
		} 
		
		System.out.println("--CADASTRANDO PRODUTO--");

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

		System.out.println("Insira o Preço Base: ");
		BigDecimal precoBase =  new BigDecimal(scanner.nextLine());

		System.out.println("Insira a Quantidade: ");
		int quantidade = Integer.parseInt(scanner.nextLine());
	
		int tipo;
		do{
		System.out.println("Insira o Tipo (1 - Físico | 2 - Digital | 3 - Perecivel): ");
		tipo = Integer.parseInt(scanner.nextLine());
		}while(tipo < 1 || tipo > 3);

		if(tipo == 1){
			produtos[estoque++] = new ProdutoFisico(id, quantidade, nome, precoBase);
		} else if(tipo == 2){
			produtos[estoque++] = new ProdutoDigital(id, quantidade, nome, precoBase);
		} else if(tipo == 3){
			produtos[estoque++] = new ProdutoPerecivel(id, quantidade, nome, precoBase);
		}

		System.out.println("Produto cadastrado com sucesso!");
	}

	public void listarProdutos(){
		System.out.println("Tipo de produto (0 - Todos | 1 - Físico | 2 - Digital | 3 - Perecivel): ");
		int tipo = Integer.parseInt(scanner.nextLine());

		System.out.println("-- Lista de Produtos--");
		if(tipo == 0){
			for(int i = 0; i < estoque; i++) {
				System.out.printf("ID: %d | NOME: %s | PREÇO BASE: R$%.2f | QUANTIDADE: %d\n", produtos[i].getId(), produtos[i].getNome(), produtos[i].getPrecoBase(), produtos[i].getQuantidade());
			}
		}else if(tipo == 1){ 
			for(int i = 0; i < estoque; i++) {
				if(produtos[i].getTipo() == tipo){ 
					System.out.printf("ID: %d | NOME: %s | PREÇO BASE: R$%.2f | QUANTIDADE: %d\n", produtos[i].getId(), produtos[i].getNome(), produtos[i].getPrecoBase(), produtos[i].getQuantidade());
				}
			}
		} else if(tipo == 2){
			for(int i = 0; i < estoque; i++) {
				if(produtos[i].getTipo() == tipo){  
					System.out.printf("ID: %d | NOME: %s | PREÇO BASE: R$%.2f | QUANTIDADE: %d\n", produtos[i].getId(), produtos[i].getNome(), produtos[i].getPrecoBase(), produtos[i].getQuantidade());
				}
			}
		} else if(tipo == 3){ 
			for(int i = 0; i < estoque; i++) {
				if(produtos[i].getTipo() == tipo){ 
					System.out.printf("ID: %d | NOME: %s | PREÇO BASE: R$%.2f | QUANTIDADE: %d\n", produtos[i].getId(), produtos[i].getNome(), produtos[i].getPrecoBase(), produtos[i].getQuantidade());
				}
			}
		}
  }


	public void alterarProduto(){
		System.out.println("Digite o ID do produto a ser alterado: ");
		int idAlterado = Integer.parseInt(scanner.nextLine());

		int i = 0;
		boolean run = true;
		while(run && i < estoque){
			if(produtos[i].getId() == idAlterado){
				run = false;
			} else {
				i++;
			}
		}

		if(i < estoque){
			System.out.println("Insira o novo NOME: ");
			String novoNome = scanner.nextLine();
			produtos[i].setNome(novoNome);

			System.out.println("Insira o novo PREÇO BASE: ");
			BigDecimal novoPrecoBase = new BigDecimal(scanner.nextLine());
			produtos[i].setPrecoBase(novoPrecoBase);

			System.out.println("Produto Alterado com sucesso!");
		} else {
			System.out.println("Não existe um produto com este ID");
		}

	}	
}
