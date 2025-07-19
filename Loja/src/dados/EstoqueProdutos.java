import produto;
package dados;

import java.util.Scanner;

public class EstoqueProdutos{
  private static final int MAX_PRODUTOS = 100;
  private Produto[] produtos = new Produto[MAX_PRODUTOS];
  private int contador = 0;

  public int buscarPorId(int id){
    for(int i = 0; i < contador; i++){
      if(produtos[i].getId() == id){
        return false;
      }
    }
    return true;
  }

  public void cadastrarProduto(){
    if(contador == MAX_PRODUTOS)
      System.out.println("Limite máximo de clientes atingido!");
    } else {

      do{
        System.out.println("Insira o ID: ");
        int id = scanner.nextLine();
        if(!buscarPorId(id)){
          System.out.println("ID já cadastrado. Tente outro.");
        }
      while(!buscarPorId(id));

      System.out.println("Insira o Nome: ");
      String nome = scanner.nextline();

      System.out.println("Insira o Preço Base: ");
      BigDecimal precoBase = scanner.nextBigDecimal();

      do{
        System.out.println("Insira o Tipo (1 - Físico | 2 - Digital | 3 - Perecivel): ");
        int tipo = scanner.nextInt();
      }while(tipo < 1 || tipo > 3);

      if(tipo == 1){
        produtos[contador++] = new ProdutoFisico(id, nome, precoBase);
      } else if(tipo == 2){
        produtos[contador++] = new ProdutoDigital(id, nome, precoBase);
      } else if(tipo == 3){
        produtos[contador++] = new ProdutoPerecivel(id, nome, precoBase);
      }

      System.out.println("Cliente cadastrado com sucesso!");
  }

  public void listarProdutos(){
    System.out.println("Tipo de produto (0 - Todos | 1 - Físico | 2 - Digital | 3 - Perecivel): ");
    int tipo = scanner.nextInt();
        
    System.out.println("-- Lista de Produtos--");
    if(tipo == 0){
      for(int i = 0; i < contador; i++) {
        System.out.printf("ID: %d | NOME: %s | PREÇO BASE: R$%.2f\n", produtos[i].getId(), produtos[i].getNome(), produtos[i].getPrecoBase());
      }
    }else if(tipo == 1){
      if(produtos[i].getId() == id){  
        for(int i = 0; i < contador; i++) {
          System.out.printf("ID: %d | NOME: %s | PREÇO BASE: R$%.2f\n", produtos[i].getId(), produtos[i].getNome(), produtos[i].getPrecoBase());
        }
      }
    } else if(tipo == 2){
      if(produtos[i].getId() == id){  
        for(int i = 0; i < contador; i++) {
          System.out.printf("ID: %d | NOME: %s | PREÇO BASE: R$%.2f\n", produtos[i].getId(), produtos[i].getNome(), produtos[i].getPrecoBase());
        }
      }
    } else if(tipo == 3){
      if(produtos[i].getId() == id){  
        for(int i = 0; i < contador; i++) {
          System.out.printf("ID: %d | NOME: %s | PREÇO BASE: R$%.2f\n", produtos[i].getId(), produtos[i].getNome(), produtos[i].getPrecoBase());
        }
      }
    }
  }
}
