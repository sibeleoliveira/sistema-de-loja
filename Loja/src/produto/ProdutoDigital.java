package produto;

import java.math.BigDecimal; 

public class ProdutoDigital extends Produto{
  //Id do tipo;
  private static final int tipo = 2;
  private double tamanhoKB; 

  //Construtor
  public ProdutoDigital(int id, int quantidade, String nome, BigDecimal precoBase, double tamanhoKB){
    super(id, quantidade, nome, precoBase);
    this.tamanhoKB = tamanhoKB;
  }

  //Getters
  public int getTipo(){return tipo;}
  public double getTamanhoKB(){return tamanhoKB;}
  public double getEspecifico(){return tamanhoKB;}


  //Setters
  public void setTamanhoKB(int tamanhoKB){this.tamanhoKB = tamanhoKB;}
}
