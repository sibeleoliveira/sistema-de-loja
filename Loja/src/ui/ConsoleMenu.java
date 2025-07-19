package ui;

import dados;
import java.util.Scanner;

public class ConsoleMenu {
  private int input = -1;
  private ArmazenamentoClientes clientes = new ArmazenamentoClientes();
  private EstoqueProdutos produtos = new EstoqueProdutos();
  
  do{
  
    System.out.println("--Menu Principal--");
    System.out.println("1 - Cadastrar Produto     2 - Alterar Produto");
    System.out.println("3 - Cadastrar Cliente     4 - Alterar Cliente");
    System.out.println("5 - Criar Nota de Compra  6 - Listar Notas Emitidas");
    System.out.println("7 - Listar Produtos       8 - Listar Clientes");
    System.out.println("0 - Sair");

    if(input == 1){
      produtos.cadastrarProduto();
    } else if(input == 2){

    } else if(input == 3){
      clientes.cadastrarCleinte();
    } else if(input == 4){

    }else if(input == 5){

    }else if(input == 6){
      
    }else if(input == 7){
      produtos.listarProdutos();
    }else if(input == 8){
      clientes.listarClientes();
    } else if(input == 0){
      System.out.println("SAINDO...");
    }

  }while(input != 0);



  
}
