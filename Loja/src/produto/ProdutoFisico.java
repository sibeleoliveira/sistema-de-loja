package produto;

import java.math.BigDecimal;

public class ProdutoFisico extends Produto {
  private static final int tipo = 1;
  private double peso;

  public ProdutoFisico(int id, int quantidade, String nome, BigDecimal precoBase, double peso){
    super(id, quantidade, nome, precoBase);
    this.peso = peso;
  }

  //Getters
  public int getTipo(){return tipo;}
  public double getPeso(){return peso;}
  public double getEspecifico(){return peso;}


  //Setters
  public void setPeso(double peso){this.peso = peso;}
}
