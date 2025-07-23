package armazenamento;

import produto.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class ArmazenamentoProdutos extends Armazenamento{
	protected static final int MAX = 100;
  	private Produto[] produtos = new Produto[MAX];
  	private Scanner scanner = new Scanner(System.in);
	
	public Produto buscarPorId(int id){
		for(int i = 0; i < estoque; i++){
			if(produtos[i].getId() == id){
				return produtos[i];
			}
		}
    	return null;
  	}

  	public void cadastrarProduto(){
		if(estoque == MAX){
		System.out.println("Limite máximo atingido!");
		return;
		} 
		
		System.out.println("--CADASTRANDO PRODUTO-- (DIGITE SAIR PARA CANCELAR A OPERAÇÃO)");

        String inputId;
		boolean verificaCampo = false;
        do {
            System.out.println("Insira o ID: ");
			inputId = scanner.nextLine();
			if(inputId.equals("SAIR")) return; //VERIFICA SE O USUÁRIO QUER SAIR
			if(inputId.isBlank()){
				System.out.println("Campo Vazio!! Tente Novamente"); //VERIFICA SE O CAMPO ESTÁ VAZIO
			} else {
				if(buscarPorId(Integer.parseInt(inputId))!=null){ // VERIFICA SE O ID JÁ EXISTE
						System.out.println("ID já cadastrado. Tente outro.");
				} else{
					verificaCampo = true;
				}
			}
        }while(!verificaCampo);
    
        String nome;
        do {
            System.out.println("Insira o Nome: ");
            nome = scanner.nextLine();
            if(nome.isBlank()){
                System.out.println("Campo Vazio!! Tente Novamente");
            }
        } while(nome.isBlank());

		verificaCampo = false;
		String inputPrecoBase;
		do{
			System.out.println("Insira o Preço Base: ");
			inputPrecoBase = scanner.nextLine();
			if(inputPrecoBase.equals("SAIR")) return; //VERIFICA SE O USUÁRIO QUER SAIR
			if(inputPrecoBase.isBlank()){
				System.out.println("Campo Vazio!! Tente Novamente"); //VERIFICA SE O CAMPO ESTÁ VAZIO
			} else {
				verificaCampo = true;
			}
		}while(!verificaCampo);

		verificaCampo = false;
		String inputQuantidade;
		do{
			System.out.println("Insira a Quantidade: ");
			inputQuantidade = scanner.nextLine();
			if(inputQuantidade.equals("SAIR")) return; //VERIFICA SE O USUÁRIO QUER SAIR
			if(inputQuantidade.isBlank()){
				System.out.println("Campo Vazio!! Tente Novamente"); //VERIFICA SE O CAMPO ESTÁ VAZIO
			} else {
				verificaCampo = true;
			}
		}while(!verificaCampo);
	
		verificaCampo = false;
		String inputTipo;
		int tipo;
		do{
			do{
				System.out.println("Insira o Tipo (1 - Físico | 2 - Digital | 3 - Perecivel) ");
				inputTipo = scanner.nextLine();
				if(inputTipo.equals("SAIR")) return; //VERIFICA SE O USUÁRIO QUER SAIR
				if(inputTipo.isBlank()){
					System.out.println("Campo Vazio!! Tente Novamente"); //VERIFICA SE O CAMPO ESTÁ VAZIO
				} else {
					verificaCampo = true;
				}
			}while(!verificaCampo);
			tipo = Integer.parseInt(inputTipo);
			if(tipo < 1 || tipo > 3) System.out.println("Não há esse tipo, digite novamente!");
		}while(tipo < 1 || tipo > 3);

		verificaCampo = false;
		String inputEspecifico;
		do{
			if(tipo == 1) System.out.println("Insira o Peso(G): ");
			else if(tipo == 2) System.out.println("Insira o Tamanho(KB): ");
			else System.out.println("Insira a Validade(dias): ");
			inputEspecifico = scanner.nextLine();

			if(inputEspecifico.equals("SAIR")) return; //VERIFICA SE O USUÁRIO QUER SAIR
			if(inputEspecifico.isBlank()){
				System.out.println("Campo Vazio!! Tente Novamente"); //VERIFICA SE O CAMPO ESTÁ VAZIO
			} else {
				verificaCampo = true;
			}
		}while(!verificaCampo);

		if(tipo == 1){
			produtos[estoque++] = new ProdutoFisico(Integer.parseInt(inputId), Integer.parseInt(inputQuantidade), nome, new BigDecimal(inputPrecoBase), Double.parseDouble(inputEspecifico));
		} else if(tipo == 2){
			produtos[estoque++] = new ProdutoDigital(Integer.parseInt(inputId), Integer.parseInt(inputQuantidade), nome, new BigDecimal(inputPrecoBase), Double.parseDouble(inputEspecifico));
		} else if(tipo == 3){
			produtos[estoque++] = new ProdutoPerecivel(Integer.parseInt(inputId), Integer.parseInt(inputQuantidade), nome, new BigDecimal(inputPrecoBase), Double.parseDouble(inputEspecifico));
		}

		System.out.println("Produto cadastrado com sucesso!");
	}

	public boolean listarProdutos(){
		if(estoque == 0) {
			System.out.println("Não há produtos cadastrados!");
			return false;
		}
		
		String inputTipo;
		boolean verificaCampo = false;
		int tipo;
		do{
			do{
				System.out.println("Digite o tipo de produto (0 - Todos | 1 - Físico | 2 - Digital | 3 - Perecivel)");
				inputTipo = scanner.nextLine();
				if(inputTipo.isBlank()){System.out.println("Campo Vazio!! Tente Novamente");}
				else {verificaCampo = true;}
			}while(!verificaCampo);
			tipo = Integer.parseInt(inputTipo);
			if(tipo < 0 || tipo > 3) System.out.println("Não há esse tipo, digite novamente!");
		}while(tipo < 0 || tipo > 3);


		boolean verificaEstoqueTipo = false;
		System.out.println("-- Lista de Produtos--");
		if(tipo == 0){
			for(int i = 0; i < estoque; i++) {
				System.out.printf("ID: %d | NOME: %s | PREÇO BASE: R$%.2f | QUANTIDADE: %d | TIPO: %d\n", produtos[i].getId(), produtos[i].getNome(), produtos[i].getPrecoBase(), produtos[i].getQuantidade(), produtos[i].getTipo());
			}
			if(estoque != 0) verificaEstoqueTipo = true;
		}else if(tipo == 1){ 
			for(int i = 0; i < estoque; i++) {
				if(produtos[i].getTipo() == tipo){ 
					System.out.printf("ID: %d | NOME: %s | PREÇO BASE: R$%.2f | QUANTIDADE: %d | PESO(KG): %.2f\n", produtos[i].getId(), produtos[i].getNome(), produtos[i].getPrecoBase(), produtos[i].getQuantidade(), produtos[i].getEspecifico());
					verificaEstoqueTipo = true;
				}
			}
		} else if(tipo == 2){
			for(int i = 0; i < estoque; i++) {
				if(produtos[i].getTipo() == tipo){  
					System.out.printf("ID: %d | NOME: %s | PREÇO BASE: R$%.2f | QUANTIDADE: %d | TAMANHO(MB): .2f\n", produtos[i].getId(), produtos[i].getNome(), produtos[i].getPrecoBase(), produtos[i].getQuantidade(), produtos[i].getEspecifico());
					verificaEstoqueTipo = true;
				}
			}
		} else if(tipo == 3){ 
			for(int i = 0; i < estoque; i++) {
				if(produtos[i].getTipo() == tipo){ 
					System.out.printf("ID: %d | NOME: %s | PREÇO BASE: R$%.2f | QUANTIDADE: %d | VALIDADE(dias): %.1f\n", produtos[i].getId(), produtos[i].getNome(), produtos[i].getPrecoBase(), produtos[i].getQuantidade(), produtos[i].getEspecifico());
					verificaEstoqueTipo = true;
				}
			}
		}
		if(!verificaEstoqueTipo) System.out.println("Não há produtos deste tipo cadastrados!");
		return verificaEstoqueTipo;
  }


	public void alterarProduto(){
		//VERIFICA SE HÁ PRODUTOS A SEREM ALTERADOS
		if(estoque == 0){
			System.out.println("Não há produtos cadastrados!");
			return;
		} 
		

		//VERIFICA SE O ID INSERIDO É VÁLIDO, CASO NÃO, PEDE PARA INSERIR NOVAMENTE
		Produto produtoAlterado;
		boolean verificaCampo = false;
		String idAlterado;
		do{
			if(!listarProdutos()){
				return;
			}
			System.out.println("--ALTERANDO PRODUTOS-- (DIGITE SAIR PARA CANCELAR A OPERAÇÃO)");
			System.out.println("Digite o ID do produto a ser alterado: ");
			idAlterado = scanner.nextLine();

			if(idAlterado.equals("SAIR")){return;} 
			if(idAlterado.isBlank()){System.out.println("Campo Vazio!! Tente Novamente");}
			else {
				if(buscarPorId(Integer.parseInt(idAlterado)) == null) {System.out.println("ID INVÁLIDO");}
				else {
					verificaCampo = true;
				}	
			}
		}while(!verificaCampo);
		produtoAlterado = buscarPorId(Integer.parseInt(idAlterado));


		System.out.println("O que deseja alterar do produto? (1 - NOME  | 2 - PREÇO BASE | 3 - QUANTIDADE): ");
		int alteracao;
		alteracao = Integer.parseInt(scanner.nextLine());

		if(alteracao == 1){
			String novoNome;
			do {
				System.out.println("Insira o novo NOME: ");
				novoNome = scanner.nextLine();
				if(novoNome.isBlank()){
					System.out.println("Campo Vazio!! Tente Novamente");
				}
			} while(novoNome.isBlank());
			produtoAlterado.setNome(novoNome);

		} else if(alteracao == 2){

			String novoPrecoBase;
			do{
				System.out.println("Insira o novo PREÇO BASE: ");
				novoPrecoBase = scanner.nextLine();
				if(novoPrecoBase.isBlank()){
					System.out.println("Campo Vazio!! Tente Novamente");
				}
			} while(novoPrecoBase.isBlank());
			produtoAlterado.setPrecoBase(new BigDecimal(novoPrecoBase));

		} else if(alteracao == 3){
			String novaQuantidade;
			do{
				System.out.println("Insira a nova QUANTIDADE: ");
				novaQuantidade = scanner.nextLine();
				if(novaQuantidade.isBlank()){
					System.out.println("Campo Vazio!! Tente Novamente");
				}
			} while(novaQuantidade.isBlank());
			produtoAlterado.setQuantidade(Integer.parseInt(novaQuantidade));
		}

		System.out.println("Produto Alterado com sucesso!");
	}	
}
