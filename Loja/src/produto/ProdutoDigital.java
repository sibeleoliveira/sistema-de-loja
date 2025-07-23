package produto;

import java.math.BigDecimal; 

public class ProdutoDigital extends Produto{
  //Id do tipo;
  private static final int tipo = 2;
  private double tamanhoMB; 

  //Construtor
  public ProdutoDigital(int id, int quantidade, String nome, BigDecimal precoBase, double tamanhoMB){
    super(id, quantidade, nome, precoBase);
    this.tamanhoMB = tamanhoMB;
  }

  //Getters
  public int getTipo(){return tipo;}
  public double getTamanhoMB(){return tamanhoMB;}

  //Setters
  public void setTamanhoMB(int tamanhoMB){this.tamanhoMB = tamanhoMB;}
}
